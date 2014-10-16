package com.rainty.fk.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.AssetsHistory;
import com.rainty.fk.entity.AssetsUser;
import com.rainty.fk.entity.AssetsUserPK;

public class TestDataSet {
	public static final List<Asset> getAssets() {
		ArrayList<Asset> assets = new ArrayList<Asset>();
		final Asset _a1 = new Asset.Builder().assetName("EH310269").assetType("PC").location("FAB7").updateUser("TEST")
				.description("demo description").updateDt(new Timestamp(System.nanoTime())).build();
		final Asset _a2 = new Asset.Builder().assetName("NH920122").assetType("NoteBook").location("FAB7").updateUser("TEST")
				.description("demo description").updateDt(new Timestamp(System.nanoTime())).build();
		assets = new ArrayList<Asset>();
		assets.add(_a1);
		assets.add(_a2);
		return assets;
	}

	public static final List<AssetsHistory> getHistory() {
		final List<Asset> assets = TestDataSet.getAssets();
		final ArrayList<AssetsHistory> assetsHistory = new ArrayList<AssetsHistory>();
		for (final Asset a : assets) {
			assetsHistory.add(new AssetsHistory(a));
		}
		return assetsHistory;
	}

	public static final List<AssetsUser> getAssetsUser() {
		final List<AssetsUser> assetUsers = new ArrayList<AssetsUser>();
		final AssetsUserPK k1 = new AssetsUserPK();
		k1.setUserId(1L);
		k1.setAssetId(1L);
		final AssetsUser u1 = new AssetsUser();
		u1.setId(k1);
		u1.setUpdateDt(new Timestamp(System.nanoTime()));
		u1.setUpdateUser("TEST");
		u1.setActive("A");
		u1.setUserType(AssetOwnerType.OWNER);

		final AssetsUserPK k2 = new AssetsUserPK();
		k2.setUserId(1L);
		k2.setAssetId(2L);
		final AssetsUser u2 = new AssetsUser();
		u2.setId(k2);
		u2.setUpdateDt(new Timestamp(System.nanoTime()));
		u2.setUpdateUser("TEST");
		u2.setActive("A");
		u2.setUserType(AssetOwnerType.USER);

		assetUsers.add(u1);
		assetUsers.add(u2);
		return assetUsers;
	}

}
