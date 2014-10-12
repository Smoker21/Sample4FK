package com.rainty.fk.service;

import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.UserInfo;

public interface AssetService {
	Asset addAssetUser(Asset asset, List<UserInfo> users, AssetOwnerType type);
	Asset save(Asset asset,String updater);
	List<Asset> save(List<Asset> asset, String updater);	
}
