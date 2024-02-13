package com.inventoryApplication.logisticsService.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryApplication.logisticsService.dto.CreateQuoteDTO;
import com.inventoryApplication.logisticsService.dto.GetQuoteDTO;
import com.inventoryApplication.logisticsService.model.Quote;
import com.inventoryApplication.logisticsService.model.QuoteGroup;
import com.inventoryApplication.logisticsService.model.QuoteProduct;
import com.inventoryApplication.logisticsService.repository.QuoteGroupRepository;
import com.inventoryApplication.logisticsService.repository.QuoteProductRepository;
import com.inventoryApplication.logisticsService.repository.QuoteRepository;
import com.inventoryApplication.logisticsService.service.QuoteService;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

@Service
public class QuoteServiceImpl implements QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private QuoteProductRepository quoteProductRepository;
	
	@Autowired
	private QuoteGroupRepository quoteGroupRepository;

	@Override
	public GetQuoteDTO createQuote(CreateQuoteDTO quoteDto) {
		StoreAndCategoryValidatior validator = new StoreAndCategoryValidatior();
		validator.validateStore(quoteDto.getStoreId());
		validator.goodownValidator(quoteDto.getGoodownId());
		Quote quote = new Quote();
		quote.setGoodownId(quoteDto.getGoodownId());
		quote.setQuotePrice(quoteDto.getQuotePrice());
		quote.setStoreId(quoteDto.getStoreId());
		Quote savedQuote = quoteRepository.save(quote);
		quoteDto.getQuoteProducts().forEach(quoteProduct->{
			QuoteProduct savedProduct = quoteProductRepository.save(quoteProduct);
			QuoteGroup quoteGroup = new QuoteGroup();
			quoteGroup.setQuoteGroup("QG"+savedQuote.getQuoteId());
			quoteGroup.setQuoteId(savedQuote.getQuoteId());
			quoteGroup.setProductId(savedProduct.getProductId());
			quoteGroupRepository.save(quoteGroup);
		});
		GetQuoteDTO getQuoteDto = new GetQuoteDTO();
		getQuoteDto.setGoodownId(quoteDto.getGoodownId());
		getQuoteDto.setQuoteId(savedQuote.getQuoteId());
		getQuoteDto.setQuotePrice(savedQuote.getQuotePrice());
		getQuoteDto.setStoreId(savedQuote.getStoreId());
		getQuoteDto.setQuoteProducts(quoteDto.getQuoteProducts());
		return getQuoteDto;
	}

	@Override
	public GetQuoteDTO getQuoteByQuoteId(int quoteId) {
		Optional<Quote> quote = quoteRepository.findById(quoteId);
		List<QuoteProduct> products = new ArrayList<>();
		if(quote.isEmpty() || quote==null) {
			
		}
		GetQuoteDTO quoteDto = new GetQuoteDTO();
		quoteDto.setGoodownId(quote.get().getGoodownId());
		quoteDto.setQuoteId(quoteId);
		quoteDto.setQuotePrice(quote.get().getQuotePrice());
		quoteDto.setStoreId(quote.get().getStoreId());
		List<QuoteGroup> groups = quoteGroupRepository.findAllByQuoteId(quoteId);
		if(groups.isEmpty() || groups==null) {
			quoteDto.setQuoteProducts(products);
		}else {
			groups.forEach(group->{
				Optional<QuoteProduct>quoteProduct = quoteProductRepository.findById(group.getProductId());
				products.add(quoteProduct.get());
			});
			quoteDto.setQuoteProducts(products);
		}
		
		return quoteDto;
	}

	@Override
	public void deleteQuoteById(int quoteId) {
		Optional<Quote> quote = quoteRepository.findById(quoteId);
		if(quote.isEmpty() || quote==null) {
			
		}
		quoteRepository.delete(quote.get());
	}

	@Override
	public void deleteProductInQuote(int quoteId,int productId) {
		Optional<Quote> quote = quoteRepository.findById(quoteId);
		if(quote.isEmpty() || quote==null) {
			
		}
		QuoteGroup group = quoteGroupRepository.findByQuoteIdAndProductId(quoteId, productId);
		quoteGroupRepository.delete(group);
	}

	@Override
	public GetQuoteDTO addProductInQuote(int quoteId,QuoteProduct product) {
		Optional<Quote> quote = quoteRepository.findById(quoteId);
		List<QuoteProduct> products = new ArrayList<>();
		if(quote.isEmpty() || quote==null) {
			
		}
		GetQuoteDTO quoteDto = new GetQuoteDTO();
		quoteDto.setGoodownId(quote.get().getGoodownId());
		quoteDto.setQuoteId(quoteId);
		quoteDto.setQuotePrice(quote.get().getQuotePrice());
		quoteDto.setStoreId(quote.get().getStoreId());
		products.add(product);
		List<QuoteGroup> groups = quoteGroupRepository.findAllByQuoteId(quoteId);
			groups.forEach(group->{
				Optional<QuoteProduct>quoteProduct = quoteProductRepository.findById(group.getProductId());
				products.add(quoteProduct.get());
			});
			quoteDto.setQuoteProducts(products);
		return quoteDto;
		
	}

	@Override
	public GetQuoteDTO changePriceInQuote(int quoteId,double price) {
		Optional<Quote> quote = quoteRepository.findById(quoteId);
		List<QuoteProduct> products = new ArrayList<>();
		if(quote.isEmpty() || quote==null) {
			
		}
		quote.get().setQuotePrice(price);
		Quote savedQuote = quoteRepository.save(quote.get());
		GetQuoteDTO quoteDto = new GetQuoteDTO();
		quoteDto.setGoodownId(savedQuote.getGoodownId());
		quoteDto.setQuoteId(quoteId);
		quoteDto.setQuotePrice(savedQuote.getQuotePrice());
		quoteDto.setStoreId(savedQuote.getStoreId());
		List<QuoteGroup> groups = quoteGroupRepository.findAllByQuoteId(quoteId);
			groups.forEach(group->{
				Optional<QuoteProduct>quoteProduct = quoteProductRepository.findById(group.getProductId());
				products.add(quoteProduct.get());
			});
			quoteDto.setQuoteProducts(products);
		
		
		return quoteDto;
		
	}

}
