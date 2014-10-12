package com.rainty.fk.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetsHistory;

public class TestDataSet {
	public static final List<Asset> getAssets() {
		ArrayList<Asset> assets = new ArrayList<Asset>();
		Asset _a1 = new Asset.Builder().assetName("EH310269").assetType("PC")
				.location("FAB7").updateUser("TEST")
				.description("demo description").updateDt(new Timestamp(System.nanoTime())).build();
		Asset _a2 = new Asset.Builder().assetName("NH920122")
				.assetType("NoteBook").location("FAB7").updateUser("TEST")
				.description("demo description").updateDt(new Timestamp(System.nanoTime())).build();
		assets = new ArrayList<Asset>();
		assets.add(_a1);
		assets.add(_a2);		
		return assets; 
	}
	
	public static final List<AssetsHistory> getHistory() {
		List<Asset> assets = TestDataSet.getAssets();
		ArrayList<AssetsHistory> assetsHistory = new ArrayList<AssetsHistory>(); 
		for (Asset a : assets) {
			assetsHistory.add(new AssetsHistory(a));
		}
		return assetsHistory; 
	}
}
