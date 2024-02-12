package com.inventoryApplication.logisticsService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Category {
	
	@Id
	@Getter
	@Setter
	@Column
	private String categoryId;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="goodownId",nullable=false)
	private Goodown goodownId;
	
	@Getter
	@Setter
	@Column
	private int goodownCapacity;
	
	@Getter
	@Setter
	@Column
	private int occupiedCapacity;
	
	@Getter
	@Setter
	@Column
	private int availableCapacity;

}
