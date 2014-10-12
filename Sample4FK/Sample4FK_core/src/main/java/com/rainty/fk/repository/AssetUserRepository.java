package com.rainty.fk.repository;

import org.springframework.data.repository.CrudRepository;

import com.rainty.fk.entity.AssetsUser;
import com.rainty.fk.entity.AssetsUserPK;

public interface AssetUserRepository extends CrudRepository<AssetsUser,AssetsUserPK> {

}
