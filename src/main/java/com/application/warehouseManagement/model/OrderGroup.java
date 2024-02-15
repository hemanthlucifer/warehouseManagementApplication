package com.application.warehouseManagement.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class OrderGroup {
	
	@Getter
	@Setter
	@Column
	@Id
	private int groupId;
	
	@Getter
	@Setter
	@Column
	private UUID orderId;
	
	@Getter
	@Setter
	@Column
	private String productId;

}
