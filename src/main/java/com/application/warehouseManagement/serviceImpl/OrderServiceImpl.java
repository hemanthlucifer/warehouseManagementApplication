package com.application.warehouseManagement.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.GetOrderDTO;
import com.application.warehouseManagement.dto.OrderDTO;
import com.application.warehouseManagement.model.Order;
import com.application.warehouseManagement.model.OrderGroup;
import com.application.warehouseManagement.model.OrderProduct;
import com.application.warehouseManagement.repository.OrderGroupRepository;
import com.application.warehouseManagement.repository.OrderProductRepository;
import com.application.warehouseManagement.repository.OrderRepository;
import com.application.warehouseManagement.service.OrderService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.OrderQuality;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private Convertor convertor;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderGroupRepository groupRepository;
	
	@Autowired
	private OrderProductRepository orderProductRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;

	@Override
	public GetOrderDTO createOrder(OrderDTO orderDTO) {
		validator.goodownValidator(orderDTO.getGoodownId());
		validator.validateStore(orderDTO.getStoreId());
		Order order = convertor.convertOrderDTOToEntity(orderDTO);
		order.setOrderId(UUID.randomUUID());
		orderDTO.getOrderProducts().forEach(orderProduct -> {
			OrderGroup group = new OrderGroup();
			group.setOrderId(order.getOrderId());
			group.setProductId(orderProduct.getProductId());
			groupRepository.save(group);
			orderProductRepository.save(orderProduct);
		});
		Order savedOrder = orderRepository.save(order);
		GetOrderDTO getOrderDTO = convertor.convertOrderEntityToDTO(savedOrder);
		List<String> productId =  groupRepository.findAllProductIdByOrderId(order.getOrderId());
		List<OrderProduct> products = orderProductRepository.findAllById(productId);
		getOrderDTO.setOrderProducts(products);
		return getOrderDTO;
	}

	@Override
	public GetOrderDTO getOrder(UUID orderId) {
		validator.validateOrder(orderId);
		Order order = orderRepository.findById(orderId).get();
		GetOrderDTO getOrderDTO = new GetOrderDTO();
		getOrderDTO = convertor.convertOrderEntityToDTO(order);
		List<String> productId =  groupRepository.findAllProductIdByOrderId(order.getOrderId());
		List<OrderProduct> products = orderProductRepository.findAllById(productId);
		getOrderDTO.setOrderProducts(products);
		return getOrderDTO;
	}

	@Override
	public GetOrderDTO updateQualityAndOntimeStatus(GetOrderDTO orderDTO) {
		Order order = orderRepository.findById(orderDTO.getOrderId()).get();
		order.setOnTime(orderDTO.isOntime());
		boolean isValidQuality = EnumUtils.isValidEnum(OrderQuality.class, orderDTO.getQuality().toUpperCase());
		if(isValidQuality) {
			order.setQuality(orderDTO.getQuality());
		}
		GetOrderDTO getOrderDTO = convertor.convertOrderEntityToDTO(order);
		List<String> productId =  groupRepository.findAllProductIdByOrderId(order.getOrderId());
		List<OrderProduct> products = orderProductRepository.findAllById(productId);
		getOrderDTO.setOrderProducts(products);
		return getOrderDTO;
	}

	@Override
	public void deleteOrder(UUID orderId) {
		validator.validateOrder(orderId);
		orderRepository.deleteById(orderId);
	}

}
