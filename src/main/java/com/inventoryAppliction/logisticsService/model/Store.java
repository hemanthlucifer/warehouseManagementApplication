package com.inventoryAppliction.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int storeId;
	
	@Getter
	@Setter
	private String storeName;
	
	@Getter
	@Setter
	private String storeLocation;
	
	@Getter
	@Setter
	private int noOfOrderForStore;

}
