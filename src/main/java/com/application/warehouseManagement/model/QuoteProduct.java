package com.application.warehouseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class QuoteProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	@Column
	private int productId;
	
	@Getter
	@Setter
	@Column
	private String productName;
	
	@Getter
	@Setter
	@Column
	private double productCost;
	
	@Getter
	@Setter
	@Column
	private int quantity;
	
	
	
}
