package com.inventoryAppliction.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GoodownProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	private String productId;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="goodownId",nullable=false)
	private Goodown goodownId;
	
	@Getter
	@Setter
	private int  storageQuantity;
	
	@Getter
	@Setter
	private int actualQuantity;
	
	@Getter
	@Setter
	private int availableQuantity;

}
