package com.application.warehouseManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class UserGoodown {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	private int userGoodownId;
	
	@Getter
	@Setter
	private String emailId;
	
	@Getter
	@Setter
	private String goodownId;

}
