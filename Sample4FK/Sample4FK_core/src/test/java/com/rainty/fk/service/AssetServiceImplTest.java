package com.rainty.fk.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainty.fk.config.ApplicationConfig;
import com.rainty.fk.entity.Asset;
import com.rainty.fk.entity.AssetOwnerType;
import com.rainty.fk.entity.UserInfo;
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
		for (final Asset a : TestDataSet.getAssets()) {
			service.save(a, "TESTER");
		}
		logger.info("History Count:{}", historyRepo.count());
		Assert.assertEquals(4, historyRepo.count());
		// change assets
		final List<Asset> _assets = service.findAll();
		for (final Asset _a : _assets) {
			_a.setDescription("Change to test history");
		}
		service.save(_assets, "TESTER2");
		logger.info("History Count:{}", historyRepo.count());
		// Assert.assertEquals(6, historyRepo.count());
		logger.info("History found:{}", historyRepo.findAll());
		logger.info("Asset found:{}", service.findAll());
	}

	@Test
	public void testAddAssetUser() {
		final List<Asset> _assets = com.rainsoft.util.CollectionUtils.makeList(TestDataSet.getAssets());
		final List<UserInfo> _users = TestDataSet.getUserInfos();
		service.addAssetUsers(_assets.get(0), Arrays.asList(_users.get(0).getUserAcnt(), _users.get(1).getUserAcnt()),
				AssetOwnerType.USER, "TESTER3");
		service.addAssetUsers(_assets.get(0), Arrays.asList(_users.get(2).getUserAcnt()), AssetOwnerType.OWNER, "TESTER3");
	}

}
