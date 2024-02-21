package com.application.warehouseManagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.GoodownProduct;
import com.application.warehouseManagement.model.Store;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private TestEntityManager manager;
	
	GoodownProduct product;
	
	Goodown goodown;
	
	Category category;

	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
		goodown = new Goodown();
		Store store = new Store();
		goodown.setGoodownId("GI-1");
		goodown.setGoodownManager("Hemanth");
		goodown.setId(1);
		goodown.setLocation("ongole");
		category.setAvailableCapacity(100);
		category.setCategoryId("laptop");
		category.setGoodownCapacity(100);
		category.setOccupiedCapacity(50);
		category.setGoodownId(goodown);
		manager.merge(category);
		store.setNoOfOrderForStore(10);
		store.setStoreId(1);
		store.setStoreLocation("Hyderabad");
		store.setStoreName("Store");
		manager.merge(store);
		product = new GoodownProduct();
		product.setCategoryId(category);
		product.setProductDescription("lenovo laptop");
		product.setProductId("LAP001");
		product.setProductManufacturer("Lenovo");
		product.setProductVersion("V1.0");
		product.setQuantity(10);
		product.setStoreId(store);
		product.setGoodownId(goodown);
		manager.merge(product);
	}

	@Test
	void testFindAllByGoodownId() {
		List<GoodownProduct> products = repository.findAllByGoodownId(goodown);
		assertNotNull(products);
		assertEquals(products.get(0).getProductId(),"LAP001");
	}

	@Test
	void testFindAllByGoodownIdAndCategoryId() {
		List<GoodownProduct> products = repository.findAllByGoodownIdAndCategoryId(goodown, category);
		assertNotNull(products);
		assertEquals(products.get(0).getProductId(),"LAP001");
	}

}
