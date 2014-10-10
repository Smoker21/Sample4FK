package com.rainty.fk.repository;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.rainty.fk.entity.UserInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserInfoRepositoryTest {
	private final static Logger logger = LoggerFactory.getLogger(UserInfoRepositoryTest.class);
	
	List<UserInfo> users; 
	
	@Autowired
	UserInfoRepository repository;
	
	@Before
	public void setup() {
		users = new ArrayList<UserInfo>();
		UserInfo u1= new UserInfo();
		u1.setUserAcnt("HMCHENU");
		u1.setUserDept("F3MITD");
		u1.setUserName("陳蕙猛");
		u1.setLocation("FAB7");
		u1.setSecretaryAcnt("PYTSAIE");
		u1.setUpdateUser("TEST");
		u1.setUpdateDt(new Timestamp(System.nanoTime()));
		users.add(u1);
		UserInfo u2 = new UserInfo();
		u2.setUserAcnt("FKYE");
		u2.setUserDept("PCMD");
		u2.setUserName("葉富愷");
		u2.setLocation("FAB2&5");
		u2.setSecretaryAcnt("CLLINA");
		u1.setUpdateUser("TEST");
		u2.setUpdateDt(new Timestamp(System.nanoTime()));
		users.add(u2);
	}

	
	@Test
	public void testSaveS() {
		repository.save(users);
	}
	
	@Test
	public void testFind() {
		Iterable<UserInfo> list = repository.findAll();	
		for (UserInfo u : list) {
			logger.info("find result: {}", u.toString());
		}
		UserInfo _u1 = repository.findOne("HMCHENU");
		Assert.assertEquals(users.get(0), _u1);
		UserInfo _u2 = repository.findOne("FKYE");
		Assert.assertEquals(users.get(1), _u2);		
	}

}
