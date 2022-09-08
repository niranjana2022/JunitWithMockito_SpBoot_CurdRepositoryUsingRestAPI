package com.eidiko.niranjana.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ReserveFundDetailsDTO implements Serializable {
	
	private Integer reserveFundId;
	
	private String accountNumber;
	
	private String cifNumber;
	private Integer mgmntCompId;
	private Integer buildingId;
	private String reserveAccountNumber;
	private String isActive;
	private String branchCode;
	
	public ReserveFundDetailsDTO(int reserveFundId) {
		this.reserveFundId=reserveFundId;
	}
	
	
	

}
