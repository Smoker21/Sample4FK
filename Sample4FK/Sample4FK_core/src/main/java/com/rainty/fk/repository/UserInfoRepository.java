package com.rainty.fk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rainty.fk.entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
	UserInfo findByUserAcnt(String userAcnt);

	@Query("SELECT u from UserInfo u ORDER BY u.userId")
	List<UserInfo> findAllOrderByUserId();
}
