package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.model.GoodownProduct;
import com.inventoryApplication.logisticsService.repository.ProductRepository;
import com.inventoryApplication.logisticsService.service.GoodownProductService;
import com.inventoryApplication.logisticsService.util.Convertor;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

import org.springframework.util.ReflectionUtils;

public class GoodownProductsServiceImpl implements GoodownProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Convertor convertor;
	
	@Autowired
	private StoreAndCategoryValidatior storeAndCategoryValidatior;

	@Override
	public GoodownProductDTO addProductToGoodown(GoodownProductDTO goodownProductDTO) {
		//storeAndCategoryValidatior.validate(goodownProductDTO.getCategoryId().getCategoryId(), goodownProductDTO.getStoreId());
		GoodownProduct goodownProduct = convertor.convertGProductDtoToEntity(goodownProductDTO);
		goodownProduct = productRepository.save(goodownProduct);
		GoodownProductDTO productDto = convertor.convertGoodownProductToDto(goodownProduct);
		return productDto;
	}

	@Override
	public GoodownProductDTO updateGoodownProduct(String productId,Map<String, Object> fields) {
		Optional<GoodownProduct> product = productRepository.findById(productId);
		if(product.isEmpty() || product==null) {
			return null;
		}
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(GoodownProduct.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, product.get(), value);
		});
		return convertor.convertGoodownProductToDto(product.get());
	}

	@Override
	public GoodownProductDTO getGoodownProductById(String productId) {
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		if(goodownProduct==null||goodownProduct.isEmpty()) {
			return null;
		}
		GoodownProductDTO goodownProductDto = convertor.convertGoodownProductToDto(goodownProduct.get());
		return goodownProductDto;
	}

	@Override
	public void deleteGoodownProductById(String productId) {
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		if(goodownProduct==null || goodownProduct.isEmpty()) {
			
		}
		productRepository.delete(goodownProduct.get());
	}

	@Override
	public List<GoodownProductDTO> getAllProductsInAGoodown(String goodownId) {
		List<GoodownProduct> products = productRepository.findAllByGoodownId(goodownId);
		if(products==null) {
			return null;
		}
		List<GoodownProductDTO> productDto = new ArrayList<>();
		products.forEach(product->{
			GoodownProductDTO goodownProductDTo = convertor.convertGoodownProductToDto(product);
			productDto.add(goodownProductDTo);
		});
		return productDto;
	}

}
