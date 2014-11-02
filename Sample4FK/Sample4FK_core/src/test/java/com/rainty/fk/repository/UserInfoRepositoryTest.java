package com.rainty.fk.repository;

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
import com.rainty.fk.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserInfoRepositoryTest {
	private final static Logger logger = LoggerFactory.getLogger(UserInfoRepositoryTest.class);

	@Autowired
	UserInfoRepository repository;

	@Test
	public void testSaveS() {
		repository.save(TestDataSet.getUserInfos());
		final List<UserInfo> users = TestDataSet.getUserInfos();
		final Iterable<UserInfo> list = repository.findAllOrderByUserId();
		for (final UserInfo u : list) {
			logger.info("find result: {}", u.toString());
		}
		final UserInfo _u1 = repository.findByUserAcnt("USER1");
		Assert.assertEquals(users.get(0).getUserAcnt(), _u1.getUserAcnt());
		final UserInfo _u2 = repository.findByUserAcnt("USER2");
		Assert.assertEquals(users.get(1).getUserAcnt(), _u2.getUserAcnt());
		final UserInfo _u3 = repository.findByUserAcnt("USER3");
		Assert.assertEquals(users.get(3).getUserAcnt(), _u3.getUserAcnt());
		// not found test
		final UserInfo _u4 = repository.findByUserAcnt("NOBODY");
		Assert.assertNull(_u4);
	}

}
