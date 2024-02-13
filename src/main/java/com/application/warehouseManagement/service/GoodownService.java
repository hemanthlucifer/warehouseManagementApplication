package com.application.warehouseManagement.service;

import java.util.Map;

import com.application.warehouseManagement.dto.GetGoodownDTO;
import com.application.warehouseManagement.dto.GoodownDTO;

public interface GoodownService {

	public GetGoodownDTO createGoodown(GoodownDTO goodownDTO);
	public GetGoodownDTO updateGoodownDetails(String goodownId, Map<String,Object> fields);
	public GetGoodownDTO getGoodownByGoodownId(String goodownId);
	public void deleteGoodownByGoodownId(String goodownId);
	
	
}
