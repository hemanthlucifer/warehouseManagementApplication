package com.application.warehouseManagement.util;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.application.warehouseManagement.exceptions.CategoryNotFoundException;
import com.application.warehouseManagement.exceptions.GoodownNotFoundException;
import com.application.warehouseManagement.exceptions.MessageCodes;
import com.application.warehouseManagement.exceptions.ProductNotFoundException;
import com.application.warehouseManagement.exceptions.StoreNotFoundException;
import com.application.warehouseManagement.exceptions.UserNotFoundException;
import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.GoodownProduct;
import com.application.warehouseManagement.model.Order;
import com.application.warehouseManagement.model.Store;
import com.application.warehouseManagement.model.User;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.repository.OrderRepository;
import com.application.warehouseManagement.repository.ProductRepository;
import com.application.warehouseManagement.repository.StoreRepository;
import com.application.warehouseManagement.repository.UserRepository;

@Component
public class StoreAndCategoryValidatior {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private OrderRepository orderRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreAndCategoryValidatior.class);
	
	public void validate(String categoryId,int storeId){
		logger.info("validate started");
		Optional<Store> store = storeRepository.findById(storeId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(!store.isEmpty()&&!category.isEmpty()) {
			logger.warn("No category or store found");
		}
		logger.info("validate completed");
	}
	
	public void goodownValidator(String goodownId) {
		logger.info("goodownValidator started");
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			logger.warn("No goodown found with the given goodown id");
			throw new GoodownNotFoundException(messageSource.getMessage(MessageCodes.goodownNotFound, null, LocaleContextHolder.getLocale()));
		}
		logger.info("goodownValidator completed");
	}
	
	public void validateStore(int storeId) {
		logger.info("validateStore started");
		Optional<Store> store = storeRepository.findById(storeId);
		if(store.isEmpty()) {
			logger.warn("NO store found with the given Id");
			throw new StoreNotFoundException(messageSource.getMessage(MessageCodes.storeNotFound, null,LocaleContextHolder.getLocale()));
		}
		logger.info("validateStore completed");
	}
	
	public void validateCategory(String categoryId) {
		logger.info("Validate category started");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			logger.warn("Category is not present");
			throw new CategoryNotFoundException(messageSource.getMessage(MessageCodes.categoryNotFound, null, LocaleContextHolder.getLocale()));
		}
		logger.info("Validate category completed");
		}
	
	public void validateProduct(String productId) {
		Optional<GoodownProduct> product = productRepository.findById(productId);
		if(product.isEmpty()||product==null) {
			logger.warn("No product with the given product id found");
			throw new ProductNotFoundException(messageSource.getMessage(MessageCodes.productNotFound, null, LocaleContextHolder.getLocale()));
		}
	}
	
	public void validateUser(String userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()||user==null) {
			logger.warn("No user found with the given Id");
			throw new UserNotFoundException(messageSource.getMessage(MessageCodes.userNotFound, null, LocaleContextHolder.getLocale()));
		}
	}
	
	public void validateOrder(UUID orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if(order.isEmpty()|| order==null) {
			logger.warn("No order found with the given orderid");
		}
	}

}
