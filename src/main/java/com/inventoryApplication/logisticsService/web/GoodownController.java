package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.GoodownDTO;
import com.inventoryApplication.logisticsService.service.GoodownService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;


@RestController
@RequestMapping("/goodown")
@SwaggerDefinition(info=@Info(title = "Goodown Controller", version = "v1.0",
description="This controller used for perfoming CRUD operations on the Goodown"))
@Api(value="Goodown Controller",tags="Goodown controller")
public class GoodownController {
	
	@Autowired
	private GoodownService service;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Goodown created sucessfully",response=GoodownDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@PostMapping("/")
	public ResponseEntity<GoodownDTO> createGoodown(GoodownDTO goodown) {
		GoodownDTO goodownDTO = service.createGoodown(goodown);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Goodown fetched sucessfully",response=GoodownDTO.class),
			@ApiResponse(code=404,message="Goodown not found"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@GetMapping("/{goodownId}")
	public ResponseEntity<GoodownDTO> getGoodownById(@PathVariable("goodownId")String goodownId){
		GoodownDTO goodownDTO = service.getGoodownByGoodownId(goodownId);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	

}
