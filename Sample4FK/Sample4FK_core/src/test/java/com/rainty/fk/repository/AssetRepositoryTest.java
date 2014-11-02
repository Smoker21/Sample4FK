package com.rainty.fk.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainty.fk.config.ApplicationConfig;
import com.rainty.fk.entity.Asset;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AssetRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AssetRepositoryTest.class);
	@Autowired
	AssetRepository repository;

	List<Asset> assets;

	@Before
	public void setUp() {
	}

	@Test
	public void testSaveS() {
		repository.save(TestDataSet.getAssets());
		final long count = repository.count();
		Assert.assertEquals(2l, count);
		final Iterable<Asset> assets = repository.findAll();
		for (final Iterator iterator = assets.iterator(); iterator.hasNext();) {
			final Asset asset = (Asset) iterator.next();
			logger.info("find asset: {}", asset);
		}
		Assert.assertEquals(2l, repository.count());
	}

	@After
	public void clean() {
		repository.deleteAll();
	}

}
