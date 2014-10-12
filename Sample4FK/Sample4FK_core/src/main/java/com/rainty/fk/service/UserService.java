package com.rainty.fk.service;

import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.UserInfo;

public interface UserService {
	UserInfo addAssetsIntoUser(UserInfo user, List<Asset> assets, AssetOwnerType type); 
	UserInfo addAssetsIntoUser(UserInfo user, List<Asset> assets, String type);
	List<Asset> findAssetsByUser(UserInfo user);
}
