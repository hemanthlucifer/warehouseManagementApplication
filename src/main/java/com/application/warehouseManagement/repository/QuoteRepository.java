package com.application.warehouseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Integer> {
	
	

}
