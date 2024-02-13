package com.application.warehouseManagement.service;

import com.application.warehouseManagement.dto.CreateQuoteDTO;
import com.application.warehouseManagement.dto.GetQuoteDTO;
import com.application.warehouseManagement.model.QuoteProduct;

public interface QuoteService {
	
	public GetQuoteDTO createQuote(CreateQuoteDTO quote);
	public GetQuoteDTO getQuoteByQuoteId(int quoteId);
	public void deleteQuoteById(int quoteId);
	public void deleteProductInQuote(int quoteId,int productId);
	public GetQuoteDTO addProductInQuote(int quoteId,QuoteProduct product);
	public GetQuoteDTO changePriceInQuote(int quoteId,double price);

}
