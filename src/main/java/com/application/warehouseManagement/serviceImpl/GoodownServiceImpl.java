package com.application.warehouseManagement.serviceImpl;

import java.lang.reflect.Field;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.GoodownDTO;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.service.GoodownService;
import com.application.warehouseManagement.util.Convertor;

import org.springframework.util.ReflectionUtils;
@Service
public class GoodownServiceImpl implements GoodownService {
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private Convertor convertor;

	@Override
	public GoodownDTO createGoodown(GoodownDTO goodownDTO) {
		Goodown goodown = convertor.convertGoodownDtoToEntity(goodownDTO);
		goodown = goodownRepository.save(goodown);
		goodown.setGoodownId("GI"+"-"+goodown.getId());
		goodownDTO = convertor.convertGoodownEntityToGoodownDTO(goodownRepository.save(goodown));
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
