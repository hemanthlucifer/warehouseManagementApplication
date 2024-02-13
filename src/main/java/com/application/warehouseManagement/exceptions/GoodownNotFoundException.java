package com.inventoryApplication.logisticsService.exceptions;

public class GoodownNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodownNotFoundException(String message) {
		super(message);
	}

}
