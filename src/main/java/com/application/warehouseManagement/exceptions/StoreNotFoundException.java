package com.inventoryApplication.logisticsService.exceptions;

public class StoreNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StoreNotFoundException (String message) {
		super(message);
	}

}
