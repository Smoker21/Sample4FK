package com.rainty.fk.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.rainty.fk.service.AssetServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ AssetRepositoryTest.class, UserInfoRepositoryTest.class, AssetUserRepositoryTest.class,
		HistoryRepositoryTest.class, AssetServiceImplTest.class })
public class AllTests {

}
