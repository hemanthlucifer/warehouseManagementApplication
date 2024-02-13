package com.application.warehouseManagement.service;

import java.util.List;
import java.util.Map;

import com.application.warehouseManagement.dto.GoodownProductDTO;

public interface GoodownProductService {
	
	public GoodownProductDTO addProductToGoodown(GoodownProductDTO goodownProductDTO);
	public GoodownProductDTO updateGoodownProduct(String productId,Map<String,Object> goodownProductDTO);
	public GoodownProductDTO getGoodownProductById(String goodownId);
	public void deleteGoodownProductById(String goodownId);
	public List<GoodownProductDTO> getAllProductsInAGoodown(String goodownId);
	public List<GoodownProductDTO> getAllProductsInCategoryInGoodown(String goodownId, String categoryId);

}
