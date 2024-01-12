package com.inventoryApplication.logisticsService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class QuoteGroup {
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int serialNumber;
	
	@Getter
	@Setter
	@Column
	private String quoteGroup;
	
	@Getter
	@Setter
	@Column
	private int quoteId;
	
	@Getter
	@Setter
	@Column
	private int productId;

}
