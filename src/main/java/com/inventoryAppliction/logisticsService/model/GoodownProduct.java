package com.inventoryAppliction.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Column;
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
	@Column
	private String productId;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="goodownId",nullable=false)
	@Column
	private Goodown goodownId;
	
	@Getter
	@Setter
	@Column
	private int  storageQuantity;
	
	@Getter
	@Setter
	@Column
	private int actualQuantity;
	
	@Getter
	@Setter
	@Column
	private int availableQuantity;

}
