package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.QuoteProduct;

@Repository
public interface QuoteProductRepository extends JpaRepository<QuoteProduct,Integer> {

}
