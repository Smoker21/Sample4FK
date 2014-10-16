package com.rainty.fk.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.AssetUser;
import com.rainty.fk.entity.AssetUserPK;
import com.rainty.fk.entity.UserInfo;
import com.rainty.fk.repository.AssetRepository;
import com.rainty.fk.repository.AssetUserRepository;
import com.rainty.fk.repository.UserInfoRepository;

/**
 * This is a sample to show how service works.
 * 
 * @author Lance
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserInfoRepository userRepository;

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	AssetUserRepository assetUserRepository; 

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UserInfo addAssetsIntoUser(final UserInfo user, final List<Asset> assets, final AssetOwnerType type) {
		Timestamp transDate = new Timestamp(System.nanoTime());
		Assert.notNull(user, "user cannot be null");
		Assert.notEmpty(assets, "assets cannot be empty");
		// check user 
		UserInfo _user = userRepository.findByUserAcnt(user.getUserAcnt());
		if (_user == null) {
			throw new RuntimeException("addAssetsIntoUser Error: cannot find user {" + user.getUserAcnt() + "}");
		}

		// check and create asset 
		ArrayList<Asset> _assets = new ArrayList<Asset>(assets.size());
		for (Asset asset : assets) {
			// create if assetId is null, read and check db existence if assetId is not null
			Asset _a = null;
			if (asset.getAssetId() == null) {
				asset.setUpdateDt(transDate);			
				_a = assetRepository.save(asset);
			} else {
				_a = assetRepository.findOne(asset.getAssetId());
				if (_a == null) {
					throw new RuntimeException("addAssetsIntoUser Error: cannot find asset by using id:{" + asset.getAssetId()
							+ "}");
				}
			}
			_assets.add(_a);
		}
		_user.setUserAssets(_assets);
		
		// persistent user asset relation 
		for (Asset _asset: _assets) {
			AssetUserPK id = new AssetUserPK();
			id.setAssetId(_asset.getAssetId());
			id.setUserId(_user.getUserId());
			AssetUser assetsUser = new AssetUser();
			assetsUser.setId(id);
			assetsUser.setActive("Y");
			assetsUser.setUserType(type);
			assetsUser.setUpdateDt(transDate);
		}

		return _user;
	}

	public List<Asset> findAssetsByUser(final UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserInfo addAssetsIntoUser(UserInfo user, List<Asset> assets, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
