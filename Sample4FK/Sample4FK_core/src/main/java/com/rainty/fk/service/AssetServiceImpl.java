package com.rainty.fk.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.AssetsHistory;
import com.rainty.fk.entity.UserInfo;
import com.rainty.fk.repository.AssetRepository;
import com.rainty.fk.repository.HistoryRepository;

@Service("assetService")
public class AssetServiceImpl implements AssetService {
	private static final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);
	
	@Autowired
	AssetRepository assetRepo; 
	
	@Autowired
	HistoryRepository historyRepo; 
	
	@Override
	public Asset addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * save an asset
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Asset save(Asset asset, String updater) {
		asset.setUpdateDt(new Timestamp(System.nanoTime()));
		asset.setUpdateUser(updater);
		
		Asset _a =  assetRepo.save(asset);
		AssetsHistory history = new AssetsHistory(_a);
		historyRepo.save(history);
		return _a; 
	}

	/**
	 * Save a list of assets
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Asset> save(List<Asset> assets, String updater) {
		logger.info("Start to save Assets. Count:{} by updater:{}",assets.size(),updater);
		Timestamp transDate = new Timestamp(System.nanoTime());
		LinkedList<Asset> _assets = new LinkedList<Asset>();
		LinkedList<AssetsHistory> _histories = new LinkedList<AssetsHistory>();
		for (Asset asset : assets) {
			asset.setUpdateDt(transDate);
			asset.setUpdateUser(updater);
			_assets.add(asset);
		}
		
		List<Asset> result = com.rainsoft.util.CollectionUtils.makeList(assetRepo.save(_assets));
		logger.info("Save assets successful");
		for (Asset asset:result) {
			asset.setDescription("just for fun");
			AssetsHistory _h = new AssetsHistory(asset);
			_histories.add(_h);			
		}
		historyRepo.save(_histories);
		logger.info("Save history successful");
		return result; 		
	}


}
