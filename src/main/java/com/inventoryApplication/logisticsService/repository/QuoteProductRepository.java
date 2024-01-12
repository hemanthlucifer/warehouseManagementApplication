package com.inventoryApplication.logisticsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryApplication.logisticsService.model.QuoteProduct;

@Repository
public interface QuoteProductRepository extends JpaRepository<QuoteProduct,Integer> {

}
