package com.inventoryApplication.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column
	private int storeId;
	
	@Getter
	@Setter
	@Column
	private String storeName;
	
	@Getter
	@Setter
	@Column
	private String storeLocation;
	
	@Getter
	@Setter
	@Column
	private int noOfOrderForStore;

}
