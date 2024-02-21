package com.application.warehouseManagement.repository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	Category category;
	
	Goodown goodown;

	@BeforeEach
	 void setUpEntity() throws Exception {
		String goodownId = "GI-1";
		String manager = "User-1";
		String categoryId = "Laptop";
		goodown = new Goodown();
		goodown.setGoodownId(goodownId);
		goodown.setGoodownManager(manager);
		goodown.setId(1);
		goodown.setLocation("Ongole");
		
		category = new Category();
		category.setGoodownId(goodown);
		category.setAvailableCapacity(100);
		category.setCategoryId(categoryId);
		category.setGoodownCapacity(200);
		category.setOccupiedCapacity(100);
		entityManager.merge(category);
		
		
		
	}

	@Test
	void testFindAllByGoodownId() {
		String goodownid= "GI-1";
		List<Category> categories = repository.findAllByGoodownId(goodown);
		assertNotNull(categories);
		assertEquals(categories.get(0).getGoodownId().getGoodownId(),goodownid);
	}

	@Test
	void testFindById() {
		String categoryId = "Laptop";
		Category category = repository.findById(categoryId).get();
		assertEquals(category.getCategoryId(),categoryId);
	}

}
