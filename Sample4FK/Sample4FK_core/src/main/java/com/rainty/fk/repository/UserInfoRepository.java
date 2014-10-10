package com.rainty.fk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rainty.fk.entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{
	UserInfo findByUserAcnt(String userAcnt);
}
