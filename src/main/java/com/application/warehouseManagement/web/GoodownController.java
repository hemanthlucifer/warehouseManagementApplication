package com.application.warehouseManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.warehouseManagement.dto.GetGoodownDTO;
import com.application.warehouseManagement.dto.GoodownDTO;
import com.application.warehouseManagement.service.GoodownService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/goodown")
public class GoodownController {
	
	@Autowired
	private GoodownService service;
	
	@Operation(summary="create Goodown")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Goodown created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating Goodown")
	})
	@PostMapping("/")
	public ResponseEntity<GetGoodownDTO> createGoodown(@RequestBody GoodownDTO goodown) {
		GetGoodownDTO goodownDTO = service.createGoodown(goodown);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	@Operation(summary="fetch Goodown by Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Goodown created sucessfully"),
			@ApiResponse(responseCode="404", description="Goodown not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating Goodown")
	})
	@GetMapping("/{goodownId}")
	public ResponseEntity<GetGoodownDTO> getGoodownById(@PathVariable("goodownId")String goodownId){
		GetGoodownDTO goodownDTO = service.getGoodownByGoodownId(goodownId);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	

}
