package com.rainty.fk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rainty.fk.entity.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
}
