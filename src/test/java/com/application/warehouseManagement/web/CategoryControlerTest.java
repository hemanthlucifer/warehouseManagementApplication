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

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.application.warehouseManagement.dto.CategoryDTO;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.service.CategoryService;
import com.application.warehouseManagement.serviceImpl.CategoryServiceImpl;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(CategoryControler.class)
class CategoryControlerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoryService categoryService;
	
	@MockBean
	private GoodownRepository goodownRepository;
	
	@MockBean
	private StoreAndCategoryValidatior validator;
	
	CategoryDTO categoryDTO;

	@BeforeEach
	void setUp() throws Exception {
		List<CategoryDTO> categories = new ArrayList<>();
		categoryDTO = new CategoryDTO();
		categoryDTO.setAvailableCapacity(100);
		categoryDTO.setCategoryId("Laptop");
		categoryDTO.setGoodownCapacity(500);
		categoryDTO.setGoodownId("GI-01");
		categoryDTO.setOccupiedCapacity(100);
		categories.add(categoryDTO);
		when(categoryService.getAllCategoriesInGoodown("GI-01")).thenReturn(categories);
	}

	@Test
	void testCreateCategory() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJSON = ow.writeValueAsString(categoryDTO);
		when(categoryService.createCategory(categoryDTO)).thenReturn(categoryDTO);
		MvcResult mvcResult = this.mockMvc.perform(post("/category/").contentType(MediaType.APPLICATION_JSON).content(requestJSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		verify(categoryService,times(1)).createCategory(categoryDTO);
		String responseBody = mvcResult.getResponse().getContentAsString();
		CategoryDTO category = mapper.readValue(responseBody, CategoryDTO.class);
		assertEquals(category,categoryDTO);
	}

	@Test
	void testGetCategoryById() throws Exception {
		String categoryId = "Laptop";
		ObjectMapper mapper = new ObjectMapper();
		when(categoryService.getCategory(categoryId)).thenReturn(categoryDTO);
		MvcResult mvcResult = this.mockMvc.perform(get("/category/getCategory/Laptop")).andDo(print()).andExpect(status().isOk()).andReturn();
		verify(categoryService,times(1)).getCategory("Laptop");
		String responseBody = mvcResult.getResponse().getContentAsString();
		CategoryDTO category = mapper.readValue(responseBody, CategoryDTO.class);
		assertEquals(category,categoryDTO);
	}
	
	@Test
	void testGetAllCategoriesInGoodown() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		MvcResult mvcResult = this.mockMvc.perform(get("/category/GI-01")).andDo(print()).andExpect(status().isOk()).andReturn();
		verify(categoryService,times(1)).getAllCategoriesInGoodown("GI-01");
		String responseBody = mvcResult.getResponse().getContentAsString();
		List<CategoryDTO> category = mapper.readValue(responseBody, new TypeReference <List<CategoryDTO>>() {});
		assertEquals(category.get(0).getCategoryId(),categoryDTO.getCategoryId());
	}

	
}
