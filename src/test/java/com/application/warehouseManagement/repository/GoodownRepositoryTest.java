package com.application.warehouseManagement.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.application.warehouseManagement.model.Goodown;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class GoodownRepositoryTest {
	
	@Autowired
	private GoodownRepository repository;
	
	@Autowired
	private TestEntityManager manager;
	
	Goodown goodown;

	@BeforeEach
	void setUp() throws Exception {
		
		goodown = new Goodown();
		goodown.setGoodownId("GI-1");
		goodown.setGoodownManager("Hemanth");
		goodown.setId(1);
		goodown.setLocation("Ongole");
		manager.merge(goodown);
		
	}

	@Test
	void testFindByGoodownId() {
		Goodown goodown = repository.findByGoodownId("GI-1");
		assertEquals(goodown.getGoodownId(),"GI-1");
	}

}
