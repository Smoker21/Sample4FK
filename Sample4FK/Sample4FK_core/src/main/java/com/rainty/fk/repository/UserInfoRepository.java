package com.rainty.fk.repository;

import org.springframework.data.repository.CrudRepository;

import com.rainty.fk.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo,String>{
	
}
