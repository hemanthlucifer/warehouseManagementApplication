package com.application.warehouseManagement.serviceImpl;

import java.lang.reflect.Field;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.GetGoodownDTO;
import com.application.warehouseManagement.dto.GoodownDTO;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.service.GoodownService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;

import org.springframework.util.ReflectionUtils;
@Service
public class GoodownServiceImpl implements GoodownService {
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;
	
	@Autowired
	private Convertor convertor;

	@Override
	public GetGoodownDTO createGoodown(GoodownDTO goodownDTO) {
		Goodown goodown = convertor.convertGoodownDtoToEntity(goodownDTO);
		goodown = goodownRepository.save(goodown);
		goodown.setGoodownId("GI"+"-"+goodown.getId());
		GetGoodownDTO getGoodownDTO = convertor.convertGoodownEntityToGoodownDTO(goodownRepository.save(goodown));
		return getGoodownDTO;
	}

	@Override
	public GetGoodownDTO updateGoodownDetails(String goodownId, Map<String, Object> fields) {
		validator.goodownValidator(goodownId);
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(Goodown.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, goodown, value);
			
		});
		return convertor.convertGoodownEntityToGoodownDTO(goodown);
	}

	@Override
	public GetGoodownDTO getGoodownByGoodownId(String goodownId) {
		validator.goodownValidator(goodownId);
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		return convertor.convertGoodownEntityToGoodownDTO(goodown);
	}

	@Override
	public void deleteGoodownByGoodownId(String goodownId) {
		validator.goodownValidator(goodownId);
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		goodownRepository.delete(goodown);
	}

}
