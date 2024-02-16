package com.application.warehouseManagement.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.warehouseManagement.dto.GetOrderDTO;
import com.application.warehouseManagement.dto.OrderDTO;
import com.application.warehouseManagement.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@Operation(summary="create Order")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Order created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating store")
	})
	@PostMapping("/")
	public ResponseEntity<GetOrderDTO> createOrder(OrderDTO orderDTO) {
		GetOrderDTO getOrderDTO = orderService.createOrder(orderDTO);
		return new ResponseEntity<>(getOrderDTO,HttpStatus.OK);
	}
	
	@Operation(summary="fetch order")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Order fetched sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching order"),
			@ApiResponse(responseCode="404", description="No order found with the given Id")
	})
	@GetMapping("/{orderId}")
	public ResponseEntity<GetOrderDTO> getOrderById(@PathVariable("orderId") UUID orderId){
		GetOrderDTO orderDTO = orderService.getOrder(orderId);
		return new ResponseEntity<>(orderDTO,HttpStatus.OK);
	}
	
	@Operation(summary="update order")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Order updated sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while updating order"),
			@ApiResponse(responseCode="404", description="No order found with the given Id")
	})
	@PatchMapping("/")
	public ResponseEntity<GetOrderDTO> updateOrderFeedback(GetOrderDTO getOrderDTO){
		GetOrderDTO orderDTO = orderService.updateQualityAndOntimeStatus(getOrderDTO);
		return new ResponseEntity<>(orderDTO,HttpStatus.OK);
	}
	
	@Operation(summary="delete order")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Order deleted sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while deleting order"),
			@ApiResponse(responseCode="404", description="No order found with the given Id")
	})
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Object> deleteOrderById(@PathVariable UUID orderId){
		orderService.deleteOrder(orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
