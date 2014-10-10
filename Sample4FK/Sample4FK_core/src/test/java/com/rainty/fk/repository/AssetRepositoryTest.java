package com.rainty.fk.repository;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		Asset _a1 = new Asset.Builder().assetName("EH310269").assetType("PC")
				.location("FAB7").updateUser("TEST")
				.description("demo description").build();
		Asset _a2 = new Asset.Builder().assetName("NH920122")
				.assetType("NoteBook").location("FAB7").updateUser("TEST")
				.description("demo description").build();
		assets = new ArrayList<Asset>();
		assets.add(_a1);
		assets.add(_a2);
	}

	@Test
	public void testSaveS() {
		repository.save(assets);
		long count = repository.count();
		Assert.assertEquals(2l, count);

	}

	@Test
	public void testFindAll() {
		Iterable<Asset> assets = repository.findAll();
		for (Iterator iterator = this.assets.iterator(); iterator.hasNext();) {
			Asset asset = (Asset) iterator.next();
			logger.info("find asset: {}", asset);
		}
	}

}
