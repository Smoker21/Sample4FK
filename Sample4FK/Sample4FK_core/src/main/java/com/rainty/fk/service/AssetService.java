package com.rainty.fk.service;

import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.UserInfo;

public interface AssetService {
	Asset addAssetUsers(Asset asset, List<String> userAcnts, AssetOwnerType type, final String updater);

	Asset save(Asset asset, String updater);

	List<Asset> save(List<Asset> asset, String updater);

	Asset addAssetUser(final Asset asset, final List<UserInfo> users, final AssetOwnerType type, final String updater);

	List<Asset> findAll();
}
