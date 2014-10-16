package com.rainty.fk.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.AssetsHistory;
import com.rainty.fk.entity.AssetsUser;
import com.rainty.fk.entity.AssetsUserPK;
import com.rainty.fk.entity.UserInfo;
import com.rainty.fk.repository.AssetRepository;
import com.rainty.fk.repository.AssetUserRepository;
import com.rainty.fk.repository.HistoryRepository;

@Service("assetService")
public class AssetServiceImpl implements AssetService {
	private static final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

	@Autowired
	AssetRepository assetRepo;

	@Autowired
	HistoryRepository historyRepo;

	@Autowired
	AssetUserRepository assetUserRepo;

	@PersistenceContext
	EntityManager em;

	@Transactional(propagation = Propagation.REQUIRED)
	public Asset addAssetUser(final Asset asset, final List<UserInfo> users, final AssetOwnerType type, final String updater) {
		// check parameter first
		Assert.notNull(asset, "addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type) asset cannot be null");
		Assert.notNull(users, "addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type) users cannot be null");
		Assert.notEmpty(users, "addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type) users cannot be empty");
		Assert.noNullElements(users.toArray(),
				"addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type) users cannot contain null");
		/**
		 *
		 * don't use this kind of write method. Check it, if errors, just throw
		 * runtime exception. Error should use error handle. Logic switch use
		 * for normal business rule.
		 *
		 * if (checkUserList(users) { rest operations.. } else { throw
		 * exception. }
		 *
		 *
		 *
		 */
		checkUserList(users);
		final Timestamp tranDate = new Timestamp(System.nanoTime());
		// save asset and get jpa managed object
		final Asset _asset = this.save(asset, updater);
		// create many-to-many reference table key
		final ArrayList<AssetsUser> assetUsers = new ArrayList<AssetsUser>();
		for (final UserInfo u : users) {
			final AssetsUser _assetUser = new AssetsUser();
			final AssetsUserPK _pk = new AssetsUserPK();
			_pk.setAssetId(_asset.getAssetId());
			_pk.setUserId(u.getUserId());
			_assetUser.setActive("A");
			_assetUser.setId(_pk);
			_assetUser.setUpdateDt(tranDate);
			_assetUser.setUpdateUser(updater);
		}
		assetUserRepo.save(assetUsers);
		assetUserRepo.findByAssetId(_asset.getAssetId());
		_asset.setAssetUsers(assetUsers);
		return _asset;
	}

	private void checkUserList(final List<UserInfo> users) {
		for (final UserInfo userInfo : users) {
			if (!userInfo.isValidUser()) {
				throw new RuntimeException("Invalidate Users [" + userInfo.toString() + "]");
			}
		}
	}

	/**
	 * save an asset
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Asset save(final Asset asset, final String updater) {
		asset.setUpdateDt(new Timestamp(System.nanoTime()));
		asset.setUpdateUser(updater);

		final Asset _a = assetRepo.save(asset);
		final AssetsHistory history = new AssetsHistory(_a);
		historyRepo.save(history);
		return _a;
	}

	/**
	 * Save a list of assets
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Asset> save(final List<Asset> assets, final String updater) {
		logger.info("Start to save Assets. Count:{} by updater:{}", assets.size(), updater);
		final Timestamp transDate = new Timestamp(System.nanoTime());
		final LinkedList<Asset> _assets = new LinkedList<Asset>();
		final LinkedList<AssetsHistory> _histories = new LinkedList<AssetsHistory>();
		for (final Asset asset : assets) {
			asset.setUpdateDt(transDate);
			asset.setUpdateUser(updater);
			_assets.add(asset);
		}

		final List<Asset> result = com.rainsoft.util.CollectionUtils.makeList(assetRepo.save(_assets));
		logger.info("Save assets successful");
		for (final Asset asset : result) {
			asset.setDescription("just for fun");
			final AssetsHistory _h = new AssetsHistory(asset);
			_histories.add(_h);
		}
		historyRepo.save(_histories);
		logger.info("Save history successful");
		return result;
	}

	@Override
	public Asset addAssetUser(final Asset asset, final List<UserInfo> users, final AssetOwnerType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset addAssetUsers(final Asset asset, final List<String> userAcnts, final AssetOwnerType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
