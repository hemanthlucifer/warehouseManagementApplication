package com.application.warehouseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class OrderProduct {
	
	@Id
	@Getter
	@Setter
	@Column
	private String productId;
	
	@Getter
	@Setter
	@Column
	private String categoryId;
	
	@Getter
	@Setter
	@Column
	private String productName;
	
	@Getter
	@Setter
	@Column
	private String manufacturerId;
	
	@Getter
	@Setter
	@Column
	private double productPrice;
	
	@Getter
	@Setter
	@Column
	private int quantityOrdered; 

}
