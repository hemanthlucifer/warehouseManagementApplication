package com.application.warehouseManagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.application.warehouseManagement.model.OrderGroup;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class OrderGroupRepositoryTest {
	
	@Autowired
	private OrderGroupRepository repository;
	
	@Autowired
	private TestEntityManager manager;
	
	OrderGroup orderGroup;
	
	private UUID orderId = UUID.randomUUID();

	@BeforeEach
	void setUp() throws Exception {
		orderGroup = new OrderGroup();
		orderGroup.setGroupId(1);
		orderGroup.setOrderId(orderId);
		orderGroup.setProductId("laptop");
		manager.merge(orderGroup);
	}

	@Test
	void testFindAllProductIdByOrderId() {
		List<OrderGroup> productIds = repository.findAllProductIdByOrderId(orderId);
		assertNotNull(productIds);
		assertEquals(productIds.get(0).getProductId(),"laptop");
	}

}
