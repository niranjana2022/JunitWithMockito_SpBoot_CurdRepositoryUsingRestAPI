package com.eidiko.niranjana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="OA_RESERVE_FUND_DETAILS")
public class ReserveFundDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESERVE_FUND_ID")
	private Integer reserveFundId;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String acountNumber;
	
	@Column(name="CIF_NUMBER")
	private String cifNumber;
	
	@Column(name="MGMNT_COMP_ID")
	private Integer mgmntCompId;
	
	@Column(name="BUILDING_ID")
	private Integer buildingId;
	
	@Column(name="RESERVE_ACCOUNT_NUMBER")
	private String reserveAccountNumber;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="BRANCH_CODE")
	private String branchCode;
	
	@Column(name="RESERVE_FUND_PERCENTAGE")
	private String reservefundPercentage;

	@Column(name="LAST_CALCULATED_ON")
	private String lastCalculatedOn;
	public Integer getReserveFundId() {
		return reserveFundId;
	}

	public void setReserveFundId(Integer reserveFundId) {
		this.reserveFundId = reserveFundId;
	}

	public String getAcountNumber() {
		return acountNumber;
	}

	public void setAcountNumber(String acountNumber) {
		this.acountNumber = acountNumber;
	}

	public String getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}

	public Integer getMgmntCompId() {
		return mgmntCompId;
	}

	public void setMgmntCompId(Integer mgmntCompId) {
		this.mgmntCompId = mgmntCompId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getReserveAccountNumber() {
		return reserveAccountNumber;
	}

	public void setReserveAccountNumber(String reserveAccountNumber) {
		this.reserveAccountNumber = reserveAccountNumber;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getReservefundPercentage() {
		return reservefundPercentage;
	}

	public void setReservefundPercentage(String reservefundPercentage) {
		this.reservefundPercentage = reservefundPercentage;
	}

	public String getLastCalculatedOn() {
		return lastCalculatedOn;
	}

	public void setLastCalculatedOn(String lastCalculatedOn) {
		this.lastCalculatedOn = lastCalculatedOn;
	}

	@Override
	public String toString() {
		return "ReserveFundDetails [reserveFundId=" + reserveFundId + ", acountNumber=" + acountNumber + ", cifNumber="
				+ cifNumber + ", mgmntCompId=" + mgmntCompId + ", buildingId=" + buildingId + ", reserveAccountNumber="
				+ reserveAccountNumber + ", isActive=" + isActive + ", branchCode=" + branchCode
				+ ", reservefundPercentage=" + reservefundPercentage + ", lastCalculatedOn=" + lastCalculatedOn + "]";
	}


}
