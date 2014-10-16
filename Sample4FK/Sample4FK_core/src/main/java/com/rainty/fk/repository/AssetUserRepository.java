package com.rainty.fk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rainty.fk.entity.AssetUser;
import com.rainty.fk.entity.AssetUserPK;

public interface AssetUserRepository extends CrudRepository<AssetUser, AssetUserPK> {

	@Query(nativeQuery = true, value = "select * from asset_user where asset_id = ?")
	List<AssetUser> findByAssetId(Long AssetId);
}
