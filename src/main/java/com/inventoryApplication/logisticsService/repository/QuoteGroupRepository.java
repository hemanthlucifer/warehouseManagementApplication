package com.inventoryApplication.logisticsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryApplication.logisticsService.model.QuoteGroup;

@Repository
public interface QuoteGroupRepository extends JpaRepository<QuoteGroup,Integer> {
	
	List<QuoteGroup> findAllByQuoteId(int quoteId);
	QuoteGroup findByQuoteIdAndProductId(int quoteId, int productId);

}
