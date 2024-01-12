package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.inventoryApplication.logisticsService.dto.GoodownDTO;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.service.GoodownService;
import com.inventoryApplication.logisticsService.util.Convertor;

import org.springframework.util.ReflectionUtils;
public class GoodownServiceImpl implements GoodownService {
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private Convertor convertor;

	@Override
	public GoodownDTO createGoodown(GoodownDTO goodownDTO) {
		Goodown goodown = convertor.convertGoodownDtoToEntity(goodownDTO);
		goodown = goodownRepository.save(goodown);
		goodownDTO = convertor.convertGoodownEntityToGoodownDTO(goodown);
		return goodownDTO;
	}

	@Override
	public GoodownDTO updateGoodownDetails(String goodownId, Map<String, Object> fields) {
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			return null;
		}
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(Goodown.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, goodown, value);
			
		});
		return convertor.convertGoodownEntityToGoodownDTO(goodown);
	}

	@Override
	public GoodownDTO getGoodownByGoodownId(String goodownId) {
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			return null;
		}
		return convertor.convertGoodownEntityToGoodownDTO(goodown);
	}

	@Override
	public void deleteGoodownByGoodownId(String goodownId) {
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			
		}	
		goodownRepository.delete(goodown);
	}

}
