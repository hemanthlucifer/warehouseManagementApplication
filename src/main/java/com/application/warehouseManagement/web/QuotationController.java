package com.application.warehouseManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.warehouseManagement.dto.CreateQuoteDTO;
import com.application.warehouseManagement.dto.GetQuoteDTO;
import com.application.warehouseManagement.dto.GoodownProductDTO;
import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.service.QuoteService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/quotation")
public class QuotationController {
	
	@Autowired
	private QuoteService service;
	
	@Operation(summary="create catgeory")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Quotation created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating quotation")
	})
	@PostMapping("/")
	public ResponseEntity<GetQuoteDTO> createQuotation(@RequestBody CreateQuoteDTO quoteDto) {
		GetQuoteDTO quote = service.createQuote(quoteDto);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}
	
	@Operation(summary="fetch quotation")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Quotation fetched sucessfully"),
			@ApiResponse(responseCode="404", description="Quotation not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching quotation")
	})
	@GetMapping("/{quoteId}")
	public ResponseEntity<GetQuoteDTO> getQuoteById(@PathVariable("quoteId")int quoteId){
		GetQuoteDTO quote = service.getQuoteByQuoteId(quoteId);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}

}
