package com.inventoryApplication.logisticsService.service;

import com.inventoryApplication.logisticsService.dto.CreateQuoteDTO;
import com.inventoryApplication.logisticsService.dto.GetQuoteDTO;
import com.inventoryApplication.logisticsService.model.QuoteProduct;

public interface QuoteService {
	
	public GetQuoteDTO createQuote(CreateQuoteDTO quote);
	public GetQuoteDTO getQuoteByQuoteId(int quoteId);
	public void deleteQuoteById(int quoteId);
	public GetQuoteDTO deleteProductInQuote(int productId);
	public GetQuoteDTO addProductInQuote(QuoteProduct product);
	public GetQuoteDTO changePriceInQuote(double price);

}
