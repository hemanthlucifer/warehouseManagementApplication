package com.application.warehouseManagement.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.application.warehouseManagement.dto.CategoryDTO;
import com.application.warehouseManagement.dto.GetGoodownDTO;
import com.application.warehouseManagement.dto.GoodownDTO;
import com.application.warehouseManagement.service.GoodownService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(GoodownController.class)
class GoodownControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GoodownService goodownService;
	
	GoodownDTO goodownDTO;
	
	GetGoodownDTO getGoodownDTO;

	@BeforeEach
	void setUp() throws Exception {
		goodownDTO = new GoodownDTO();
		goodownDTO.setGoodownManager("Hemanth");
		goodownDTO.setLocation("Hyderabad");
		getGoodownDTO = new GetGoodownDTO();
		getGoodownDTO.setGoodownId("GI-01");
		getGoodownDTO.setGoodownManager("Hemanth");
		getGoodownDTO.setLocation("Hyderabad");
		
	}

	@Test
	void testCreateGoodown()throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJSON = ow.writeValueAsString(goodownDTO);
		when(goodownService.createGoodown(goodownDTO)).thenReturn(getGoodownDTO);
		MvcResult mvcResult = this.mockMvc.perform(post("/goodown/").contentType(MediaType.APPLICATION_JSON).content(requestJSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		verify(goodownService,times(1)).createGoodown(goodownDTO);
		String responseBody = mvcResult.getResponse().getContentAsString();
		GetGoodownDTO goodown = mapper.readValue(responseBody, GetGoodownDTO.class);
		assertEquals(goodown,getGoodownDTO);
	}

	@Test
	void testGetGoodownById()throws Exception {
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.registerModule(new JavaTimeModule());
	   when(goodownService.getGoodownByGoodownId("GI-01")).thenReturn(getGoodownDTO);
	   MvcResult mvcResult = this.mockMvc.perform(get("/goodown/GI-01")).andDo(print()).andExpect(status().isOk()).andReturn();
	   verify(goodownService,times(1)).getGoodownByGoodownId("GI-01");
	   String responseBody = mvcResult.getResponse().getContentAsString();
	   GetGoodownDTO goodown = mapper.readValue(responseBody, GetGoodownDTO.class);
	   assertEquals(goodown,getGoodownDTO);
	}

}
