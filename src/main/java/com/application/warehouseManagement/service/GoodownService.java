package com.application.warehouseManagement.service;

import java.util.Map;

import com.application.warehouseManagement.dto.GoodownDTO;

public interface GoodownService {

	public GoodownDTO createGoodown(GoodownDTO goodownDTO);
	public GoodownDTO updateGoodownDetails(String goodownId, Map<String,Object> fields);
	public GoodownDTO getGoodownByGoodownId(String goodownId);
	public void deleteGoodownByGoodownId(String goodownId);
	
	
}
