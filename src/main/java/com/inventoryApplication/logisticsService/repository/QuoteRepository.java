package com.inventoryApplication.logisticsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryApplication.logisticsService.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Integer> {
	
	

}
