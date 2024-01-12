package com.inventoryApplication.logisticsService.dto;

import java.io.Serializable;

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

}
