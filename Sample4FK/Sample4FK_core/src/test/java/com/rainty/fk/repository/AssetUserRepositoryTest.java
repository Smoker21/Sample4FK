package com.rainty.fk.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainty.fk.config.ApplicationConfig;
import com.rainty.fk.entity.AssetUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AssetUserRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AssetUserRepositoryTest.class);

	@Autowired
	AssetUserRepository assetUserRepo;

	@Test
	public void testFindByAssetId() {
		assetUserRepo.save(TestDataSet.getAssetUsers());
		final List<AssetUser> l = assetUserRepo.findByAssetId(1L);

		for (final AssetUser assetsUser : l) {
			logger.info("Assets User:" + assetsUser);
		}
		final Iterable<AssetUser> l2 = assetUserRepo.findAll();
		for (final AssetUser assetsUser : l2) {
			logger.info("Assets User:" + assetsUser);
		}
	}

}
