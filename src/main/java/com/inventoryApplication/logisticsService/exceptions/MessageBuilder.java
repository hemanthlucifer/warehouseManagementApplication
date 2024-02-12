package com.inventoryApplication.logisticsService.exceptions;

public class MessageBuilder {
	
	public String responseBuilder(String code, String message) {
		String response = code+" "+":"+" "+message;
		return response;
	}

}
