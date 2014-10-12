package com.rainty.fk.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainty.fk.config.ApplicationConfig;
import com.rainty.fk.entity.Asset;
import com.rainty.fk.repository.HistoryRepository;
import com.rainty.fk.repository.TestDataSet;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AssetServiceImplTest {

	private static final Logger logger = LoggerFactory.getLogger(AssetServiceImplTest.class);
	
	@Autowired
	AssetService service; 
	
	@Autowired
	HistoryRepository historyRepo;
	
	@Test
	public void testSaveAssetString() {
		// save one by one
		for (Asset a : TestDataSet.getAssets()) {
			service.save(a, "TESTER");
		}
		logger.info( "History Count:{}",historyRepo.count());
		// change assets  
		List<Asset> _assets = com.rainsoft.util.CollectionUtils.makeList(TestDataSet.getAssets());
		for (Asset _a : _assets) {
			_a.setDescription("Change to test history");
		}
		service.save(_assets, "TESTER2");
		logger.info( "History Count:{}",historyRepo.count());
	}

}
