package com.application.warehouseManagement.dto;

import java.io.Serializable;
import java.util.List;

import com.application.warehouseManagement.model.QuoteProduct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetQuoteDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private int quoteId;
	
	@Getter
	@Setter
	private double quotePrice;
	
	@Getter
	@Setter
	private int storeId;
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private List<QuoteProduct> quoteProducts;

}
