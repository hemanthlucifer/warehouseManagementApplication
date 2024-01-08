package com.inventoryAppliction.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class Goodown implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Getter
	private String goodownId;
	
	@Getter
	@Setter
	private String location;
	
	@Getter
	@Setter
	private String goodownManager;
	
	public Goodown(){
		this.goodownId = "GI"+"-"+this.id;
	}

}
