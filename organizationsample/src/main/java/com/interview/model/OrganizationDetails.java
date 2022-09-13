package com.interview.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "organization")
public class OrganizationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	private String createdBy;
	private Timestamp createdOn;
	private String modifiedBy;
	private Timestamp modifiedOn;
	@OneToMany(mappedBy = "organization")
    private Set<EmployeeDetails> employeeDetails = new HashSet<>();
	@OneToMany(mappedBy = "organization")
    private Set<AssetDetails> assetDetails = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public Set<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(Set<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public Set<AssetDetails> getAssetDetails() {
		return assetDetails;
	}
	public void setAssetDetails(Set<AssetDetails> assetDetails) {
		this.assetDetails = assetDetails;
	}
	public OrganizationDetails() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public OrganizationDetails(long id, String name, String address, String createdBy, Timestamp createdOn,
			String modifiedBy, Timestamp modifiedOn) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}
	@Override
	public String toString() {
		return "OrganizationDetails [id=" + id + ", name=" + name + ", address=" + address + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
	}
	
	

}
