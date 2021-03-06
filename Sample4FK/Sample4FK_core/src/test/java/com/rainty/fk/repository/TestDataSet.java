package com.rainty.fk.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.AssetUser;
import com.rainty.fk.entity.AssetUserPK;
import com.rainty.fk.entity.AssetsHistory;
import com.rainty.fk.entity.UserInfo;

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

	public static final List<UserInfo> getUserInfos() {

		final UserInfo _u1 = new UserInfo.Builder().userAcnt("USER1").location("LOC1").userDept("DEPT1").userOrg("001")
				.secretaryAcnt("SEC1").supervisor("SUPER1").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date())
				.updateUser("TEST1").userName("員工1").build();
		final UserInfo _u2 = new UserInfo.Builder().userAcnt("USER2").location("LOC1").userDept("DEPT1").userOrg("001")
				.secretaryAcnt("SEC1").supervisor("SUPER1").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date())
				.updateUser("TEST1").userName("員工2").build();
		final UserInfo _u3 = new UserInfo.Builder().userAcnt("SUPER1").location("LOC1").userDept("DEPT1").userOrg("001")
				.secretaryAcnt("SEC1").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date()).updateUser("TEST1")
				.userName("老闆1").build();
		final UserInfo _u4 = new UserInfo.Builder().userAcnt("USER3").location("LOC2").userDept("DEPT2").userOrg("002")
				.secretaryAcnt("SEC2").supervisor("SUPER2").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date())
				.updateUser("TEST1").userName("員工3").build();
		final UserInfo _u5 = new UserInfo.Builder().userAcnt("USER4").location("LOC2").userDept("DEPT2").userOrg("002")
				.secretaryAcnt("SEC2").supervisor("SUPER2").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date())
				.updateUser("TEST1").userName("員工4").build();
		final UserInfo _u6 = new UserInfo.Builder().userAcnt("SUPER2").location("LOC1").userDept("DEPT1").userOrg("001")
				.secretaryAcnt("SEC1").updateDt(new Timestamp(System.nanoTime())).onboardDt(new Date()).updateUser("TEST1")
				.userName("老闆2").build();
		final LinkedList<UserInfo> users = new LinkedList<UserInfo>();
		users.add(_u1);
		users.add(_u2);
		users.add(_u3);
		users.add(_u4);
		users.add(_u5);
		users.add(_u6);
		return users;
	}

	public static final List<AssetsHistory> getHistory() {
		final List<Asset> assets = TestDataSet.getAssets();
		final ArrayList<AssetsHistory> assetsHistory = new ArrayList<AssetsHistory>();
		for (final Asset a : assets) {
			assetsHistory.add(new AssetsHistory(a));
		}
		return assetsHistory;
	}

	public static final List<AssetUser> getAssetUsers() {
		final List<AssetUser> assetUsers = new ArrayList<AssetUser>();
		final AssetUserPK k1 = new AssetUserPK();
		k1.setUserId(1L);
		k1.setAssetId(1L);
		final AssetUser u1 = new AssetUser();
		u1.setId(k1);
		u1.setUpdateDt(new Timestamp(System.nanoTime()));
		u1.setUpdateUser("TEST");
		u1.setActive("A");
		u1.setUserType(AssetOwnerType.OWNER);

		final AssetUserPK k2 = new AssetUserPK();
		k2.setUserId(1L);
		k2.setAssetId(2L);
		final AssetUser u2 = new AssetUser();
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
