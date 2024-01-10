package com.inventoryApplication.logisticsService.service;

import java.util.Map;

import com.inventoryApplication.logisticsService.dto.GoodownDTO;

public interface GoodownService {

	public GoodownDTO createGoodown(GoodownDTO goodownDTO);
	public GoodownDTO updateGoodownDetails(String goodownId, Map<String,Object> fields);
	public GoodownDTO getGoodownByGoodownId(String goodownId);
	public void deleteGoodownByGoodownId(String goodownId);
	
	
}
