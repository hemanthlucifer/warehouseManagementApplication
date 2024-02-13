package com.application.warehouseManagement.serviceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.GoodownProductDTO;
import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.GoodownProduct;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.repository.ProductRepository;
import com.application.warehouseManagement.service.GoodownProductService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;

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
	
	

	@Override
	public GoodownProductDTO addProductToGoodown(GoodownProductDTO goodownProductDTO) {
		storeAndCategoryValidatior.validate(goodownProductDTO.getCategoryId(), goodownProductDTO.getStoreId());
		storeAndCategoryValidatior.goodownValidator(goodownProductDTO.getGoodownId());
		GoodownProduct goodownProduct = convertor.convertGProductDtoToEntity(goodownProductDTO);
		goodownProduct = productRepository.save(goodownProduct);
		GoodownProductDTO productDto = convertor.convertGoodownProductToDto(goodownProduct);
		return productDto;
	}

	@Override
	public GoodownProductDTO updateGoodownProduct(String productId,Map<String, Object> fields) {
		storeAndCategoryValidatior.validateProduct(productId);
		Optional<GoodownProduct> product = productRepository.findById(productId);
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(GoodownProduct.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, product.get(), value);
		});
		return convertor.convertGoodownProductToDto(product.get());
	}

	@Override
	public GoodownProductDTO getGoodownProductById(String productId) {
		storeAndCategoryValidatior.validateProduct(productId);
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		GoodownProductDTO goodownProductDto = convertor.convertGoodownProductToDto(goodownProduct.get());
		return goodownProductDto;
	}

	@Override
	public void deleteGoodownProductById(String productId) {
		storeAndCategoryValidatior.validateProduct(productId);
		Optional<GoodownProduct> goodownProduct = productRepository.findById(productId);
		productRepository.delete(goodownProduct.get());
	}

	@Override
	public List<GoodownProductDTO> getAllProductsInAGoodown(String goodownId) {
		storeAndCategoryValidatior.goodownValidator(goodownId);
		List<GoodownProduct> products = productRepository.findAllByGoodownId(goodownRepository.findByGoodownId(goodownId));
		List<GoodownProductDTO> productDto = new ArrayList<>();
		products.forEach(product->{
			GoodownProductDTO goodownProductDTo = convertor.convertGoodownProductToDto(product);
			productDto.add(goodownProductDTo);
		});
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
