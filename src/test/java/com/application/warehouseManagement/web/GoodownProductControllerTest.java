package com.application.warehouseManagement.web;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.application.warehouseManagement.dto.GoodownProductDTO;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.repository.StoreRepository;
import com.application.warehouseManagement.service.GoodownProductService;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(GoodownProductController.class)
class GoodownProductControllerTest {
    
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GoodownProductService goodownProductService;
	
	@MockBean
	private GoodownRepository goodownRepository;
	
	@MockBean
	private CategoryRepository categoryRepository;
	
	@MockBean
	private StoreAndCategoryValidatior validator;
	
	@MockBean
	private StoreRepository storeRepository;
	
	GoodownProductDTO goodownProductDTO;
	
	
	@BeforeEach
	void setUp() throws Exception {
		goodownProductDTO = new GoodownProductDTO();
		goodownProductDTO.setCategoryId("Laptop");
		goodownProductDTO.setGoodownId("GI-01");
		goodownProductDTO.setProductDescription("Laptop product");
		goodownProductDTO.setProductId("LAP001");
		goodownProductDTO.setProductManufacturer("Apple");
		goodownProductDTO.setProductVersion("MACBOOK");
		goodownProductDTO.setQuantity(100);
		goodownProductDTO.setStoreId(1);
		List<GoodownProductDTO> products = new ArrayList<>();
		products.add(goodownProductDTO);
		when(goodownProductService.getAllProductsInCategoryInGoodown("GI-01","Laptop")).thenReturn(products);
	}

	@Test
	void testCreateGoodown() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(goodownProductDTO);
		when(goodownProductService.addProductToGoodown(goodownProductDTO)).thenReturn(goodownProductDTO);
		MvcResult mvcResult = this.mockMvc.perform(post("/gProduct/").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		verify(goodownProductService,times(1)).addProductToGoodown(goodownProductDTO);
		String responseBody = mvcResult.getResponse().getContentAsString();
		GoodownProductDTO productDTO = mapper.readValue(responseBody, GoodownProductDTO.class);
		assertEquals(productDTO,goodownProductDTO);
	}

	@Test
	void testGetProductById() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		when(goodownProductService.getGoodownProductById("LAP001")).thenReturn(goodownProductDTO);
		MvcResult mvcResult = this.mockMvc.perform(get("/gProduct/LAP001")).andDo(print()).andExpect(status().isOk()).andReturn();
		verify(goodownProductService,times(1)).getGoodownProductById("LAP001");
		String responseBody = mvcResult.getResponse().getContentAsString();
		GoodownProductDTO productDTO = mapper.readValue(responseBody, GoodownProductDTO.class);
		assertEquals(productDTO,goodownProductDTO);
	}

	@Test
	void testGetAllProductsInCategoryInGoodown() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		MvcResult mvcResult = this.mockMvc.perform(get("/gProduct/GI-01/Laptop")).andDo(print()).andExpect(status().isOk()).andReturn();
		verify(goodownProductService,times(1)).getAllProductsInCategoryInGoodown("GI-01", "Laptop");
		String responseBody = mvcResult.getResponse().getContentAsString();
		List<GoodownProductDTO> productDTO = mapper.readValue(responseBody, new TypeReference <List<GoodownProductDTO>>() {});
		assertEquals(productDTO.get(0).getProductId(),goodownProductDTO.getProductId());
	}

}
