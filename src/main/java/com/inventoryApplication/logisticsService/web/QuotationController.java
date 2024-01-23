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
import com.inventoryApplication.logisticsService.service.QuoteService;

@RestController
@RequestMapping("/quotation")
public class QuotationController {
	
	@Autowired
	private QuoteService service;
	
	@PostMapping("/")
	public ResponseEntity<GetQuoteDTO> createQuotation(CreateQuoteDTO quoteDto) {
		GetQuoteDTO quote = service.createQuote(quoteDto);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}
	
	@GetMapping("/{quoteId}")
	public ResponseEntity<GetQuoteDTO> getQuoteById(@PathVariable("quoteId")int quoteId){
		GetQuoteDTO quote = service.getQuoteByQuoteId(quoteId);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}

}
