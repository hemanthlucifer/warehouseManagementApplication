package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.CreateQuoteDTO;
import com.inventoryApplication.logisticsService.dto.GetQuoteDTO;
import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.service.QuoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info=@Info(title = "Quotation Controller", version = "v1.0",
description="This contoller is used for perfoming CRUD operations on the Quotation"))
@Api(value="Quotation Controller",tags ="Quotation")
@RestController
@RequestMapping("/quotation")
public class QuotationController {
	
	@Autowired
	private QuoteService service;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Quotation created sucessfully",response=GetQuoteDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Quotation creation",notes="This API is used for creating the quotation",nickname="Create Quotation")
	@PostMapping("/")
	public ResponseEntity<GetQuoteDTO> createQuotation(CreateQuoteDTO quoteDto) {
		GetQuoteDTO quote = service.createQuote(quoteDto);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Quotation fetched sucessfully",response=GetQuoteDTO.class),
			@ApiResponse(code=404,message="Quotation not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@GetMapping("/{quoteId}")
	public ResponseEntity<GetQuoteDTO> getQuoteById(@PathVariable("quoteId")int quoteId){
		GetQuoteDTO quote = service.getQuoteByQuoteId(quoteId);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}

}
