package com.inventoryApplication.logisticsService.service;

import java.util.List;
import java.util.Map;

import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;

public interface GoodownProductService {
	
	public GoodownProductDTO addProductToGoodown(GoodownProductDTO goodownProductDTO);
	public GoodownProductDTO updateGoodownProduct(String productId,Map<String,Object> goodownProductDTO);
	public GoodownProductDTO getGoodownProductById(String goodownId);
	public void deleteGoodownProductById(String goodownId);
	public List<GoodownProductDTO> getAllProductsInAGoodown(String goodownId);

}
