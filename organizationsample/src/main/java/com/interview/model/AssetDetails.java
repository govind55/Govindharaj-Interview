package com.interview.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Asset")
public class AssetDetails {
	@Id
	private long id;
	private String assetName;
	private String assetCategory;
	private String assetType;
	private double price;
	private Timestamp purchaseDate;
	private Timestamp expireDate;
	private String createdBy;
	private Timestamp createdOn;
	private String modifiedBy;
	private Timestamp modifiedOn;
	@ManyToOne
    @JoinColumn(name = "org_id")
	@JsonIgnore
    private OrganizationDetails organization;
	@ManyToOne
    @JoinColumn(name = "emp_id")
	@JsonIgnore
    private EmployeeDetails employee;
	
	public AssetDetails() {
		
	}
	
	public AssetDetails(long id, String assetName, String assetCategory, String assetType, double price,
			Timestamp purchaseDate, Timestamp expireDate, String createdBy, Timestamp createdOn, String modifiedBy,
			Timestamp modifiedOn) {
		super();
		this.id = id;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetType = assetType;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.expireDate = expireDate;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetCategory() {
		return assetCategory;
	}
	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	

	public OrganizationDetails getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDetails organization) {
		this.organization = organization;
	}

	public EmployeeDetails getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AssetDetails [id=" + id + ", assetName=" + assetName + ", assetCategory=" + assetCategory + ", assetType="
				+ assetType + ", price=" + price + ", purchaseDate=" + purchaseDate + ", expireDate=" + expireDate
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + "]";
	}
	
	

}
