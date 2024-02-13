package com.application.warehouseManagement.model;

import java.io.Serializable;
import java.util.Map;

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
	@Column
	private String productManufacturer;
	
	@Getter
	@Setter
	@Column
	private String productVersion;
	
	@Getter
	@Setter
	@Column
	private String productDescription;
	
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="goodownId",nullable=false)
	private Goodown goodownId;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="categoryId",nullable=false)
	private Category categoryId;
	
	@Getter
	@Setter
	@Column
	private int quantity;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="storeId",nullable=false)
	private Store storeId; 
	
	

}
