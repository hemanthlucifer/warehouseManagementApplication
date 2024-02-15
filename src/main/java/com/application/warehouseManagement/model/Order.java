package com.application.warehouseManagement.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Getter
	@Setter
	@Column
	private UUID orderId;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private int storeId;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private String goodownId;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private LocalDate orderPlacedDate;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private LocalDate receivedDate;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private boolean isOnTime;
	
	@Getter
	@Setter
	@NotNull
	@Column
	private String quality;

}
