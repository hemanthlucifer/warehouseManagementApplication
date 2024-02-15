package com.application.warehouseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class User {
	
	@Getter
	@Setter
	@Column
	@Id
	private String emailId;
	
	@Getter
	@Setter
	@Column
	private String userName;
	
	@Getter
	@Setter
	@Column
	private String password;
	
	@Getter
	@Setter
	@Column
	private String role;

}
