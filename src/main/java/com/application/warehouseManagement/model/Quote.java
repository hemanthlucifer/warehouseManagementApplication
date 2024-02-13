package com.application.warehouseManagement.model;

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
public class Quote {
	
	@Id
	@Getter
	@Setter
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quoteId;
	
	@Getter
	@Setter
	@Column
	private double quotePrice;
	
	@Getter
	@Setter
	@Column
	private String quoteGroup;
	
	@Getter
	@Setter
	@Column
	private int storeId;
	
	@Getter
	@Setter
	@Column
	private String goodownId;
	

}
