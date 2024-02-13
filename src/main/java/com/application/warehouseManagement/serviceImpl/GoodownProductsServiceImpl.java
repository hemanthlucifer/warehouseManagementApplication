package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.model.GoodownProduct;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.repository.ProductRepository;
import com.inventoryApplication.logisticsService.service.GoodownProductService;
import com.inventoryApplication.logisticsService.util.Convertor;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

import org.springframework.util.ReflectionUtils;

@Service
public class GoodownProductsServiceImpl implements GoodownProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Convertor convertor;
	
	@Autowired
	private StoreAndCategoryValidatior storeAndCategoryValidatior;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(GoodownProductsServiceImpl.class);

	@Override
	public GoodownProductDTO addProductToGoodown(GoodownProductDTO goodownProductDTO) {
		//storeAndCategoryValidatior.validate(goodownProductDTO.getCategoryId().getCategoryId(), goodownProductDTO.getStoreId());
		logger.info("addProductToGoodown started");
		GoodownProduct goodownProduct = convertor.convertGProductDtoToEntity(goodownProductDTO);
		goodownProduct = productRepository.save(goodownProduct);
		logger.info("Product has saved to goodown");
		GoodownProductDTO productDto = convertor.convertGoodownProductToDto(goodownProduct);
		logger.info("addProductToGoodown completed");
		return productDto;
	}

	@Override
	public GoodownProductDTO updateGoodownProduct(String productId,Map<String, Object> fields) {
		logger.info("updateGoodownProduct started");
		Optional<GoodownProduct> product = productRepository.findById(productId);
		if(product.isEmpty() || product==null) {
			logger.warn("no product found with the given Id");
			return null;
		}
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(GoodownProduct.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, product.get(), value);
		});
		logger.info("updateGoodownProduct completed");
		return convertor.convertGoodownProductToDto(product.get());
	}

	@Override
	public GoodownProductDTO getGoodownProductById(String productId) {
		logger.info("getGoodownProductById started");
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		if(goodownProduct==null||goodownProduct.isEmpty()) {
			logger.warn("no product found with the given Id");
			return null;
		}
		GoodownProductDTO goodownProductDto = convertor.convertGoodownProductToDto(goodownProduct.get());
		logger.info("getGoodownProductById completed");
		return goodownProductDto;
	}

	@Override
	public void deleteGoodownProductById(String productId) {
		logger.info("deleteGoodownProductById started");
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		if(goodownProduct==null || goodownProduct.isEmpty()) {
			logger.warn("No product with the given Id found");
		}
		productRepository.delete(goodownProduct.get());
		logger.info("deleteGoodownProductById completed");
	}

	@Override
	public List<GoodownProductDTO> getAllProductsInAGoodown(String goodownId) {
		logger.info("getAllProductsInAGoodown started");
		storeAndCategoryValidatior.goodownValidator(goodownId);
		List<GoodownProduct> products = productRepository.findAllByGoodownId(goodownRepository.findByGoodownId(goodownId));
		if(products==null) {
			logger.warn("no goodown found with the given goodown Id");
			return null;
		}
		List<GoodownProductDTO> productDto = new ArrayList<>();
		products.forEach(product->{
			GoodownProductDTO goodownProductDTo = convertor.convertGoodownProductToDto(product);
			productDto.add(goodownProductDTo);
		});
		logger.info("getAllProductsInAGoodown completed");
		return productDto;
	}
	
	@Override
	public List<GoodownProductDTO> getAllProductsInCategoryInGoodown(String goodownId, String categoryId){
		storeAndCategoryValidatior.goodownValidator(goodownId);
		storeAndCategoryValidatior.validateCategory(categoryId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		List<GoodownProductDTO> goodownProductDto = new ArrayList<>();
		List<GoodownProduct> goodownProducts = productRepository.findAllByGoodownIdAndCategoryId(goodown, category.get());
		goodownProducts.forEach(goodownProduct->{
			GoodownProductDTO dto = convertor.convertGoodownProductToDto(goodownProduct);
			goodownProductDto.add(dto);
		});
		return goodownProductDto;
	}

}
