package com.rainty.fk.repository;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainty.fk.config.ApplicationConfig;
import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetsHistory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class HistoryRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(HistoryRepositoryTest.class);

	@Autowired
	HistoryRepository historyRepo;

	@Autowired
	AssetRepository assetRepo; 
	
	@Test
	public void testSaveS() {
		Iterable<Asset> assets = assetRepo.save(TestDataSet.getAssets());
		ArrayList<AssetsHistory> historys = new ArrayList<AssetsHistory>();
		for (Asset a : assets) {
			historys.add(new AssetsHistory(a));
		}
		historyRepo.save(historys);
		ArrayList<AssetsHistory> _historys = new ArrayList<AssetsHistory>();
		for (AssetsHistory h : historyRepo.findAll()) {
			_historys.add(h);
			logger.info("After created: {} ",h);
		}
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
