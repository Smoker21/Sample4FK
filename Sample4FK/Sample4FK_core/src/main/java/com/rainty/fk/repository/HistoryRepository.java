package com.rainty.fk.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rainty.fk.entity.AssetsHistory;

public interface HistoryRepository extends PagingAndSortingRepository<AssetsHistory, Long> {	
	
}
