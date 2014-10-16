package com.rainty.fk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rainty.fk.entity.AssetsUser;
import com.rainty.fk.entity.AssetsUserPK;

public interface AssetUserRepository extends CrudRepository<AssetsUser, AssetsUserPK> {

	@Query(nativeQuery = true, value = "select * from assets_user where asset_id = ?")
	List<AssetsUser> findByAssetId(Long AssetId);
}
