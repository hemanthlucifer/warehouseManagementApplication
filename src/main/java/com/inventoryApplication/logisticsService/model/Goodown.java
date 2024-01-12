package com.inventoryApplication.logisticsService.model;

import java.io.Serializable;

import jakarta.persistence.Column;
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
	@Column
	private int id;
	
	@Getter
	@Column
	private String goodownId;
	
	@Getter
	@Setter
	@Column
	private String location;
	
	@Getter
	@Setter
	@Column
	private String goodownManager;
	
	public Goodown(){
		this.goodownId = "GI"+"-"+this.id;
	}

}
