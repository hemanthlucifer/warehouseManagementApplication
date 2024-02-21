package com.application.warehouseManagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.application.warehouseManagement.model.Store;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class StoreRepositoryTest {
	
	@Autowired
	private StoreRepository repository;
	
	@Autowired
	private TestEntityManager manager;
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		Store store = new Store();
		store.setNoOfOrderForStore(100);
		store.setStoreId(1);
		store.setStoreLocation("Hyderabad");
		store.setStoreName("Store");
		manager.merge(store);
		
	}

	@Test
	void testFindByStoreName() {
		Store store = repository.findByStoreName("Store");
		assertEquals(store.getStoreName(),"Store");
	}

}
