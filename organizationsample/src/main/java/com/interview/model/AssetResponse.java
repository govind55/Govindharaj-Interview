package com.interview.model;

import java.sql.Timestamp;

public class AssetResponse {

	private String name;
	private String firstName;
	private String lastName;
	private long id;
	private String assetName;
	private String assetCategory;
	private String assetType;
	private double price;
	private Timestamp purchaseDate;
	private Timestamp expireDate;
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	
	public AssetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetResponse(String name, String firstName, String lastName, long id, String assetName,
			String assetCategory, String assetType) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetType = assetType;
	}
	@Override
	public String toString() {
		return "AssetResponse [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", id=" + id
				+ ", assetName=" + assetName + ", assetCategory=" + assetCategory + ", assetType=" + assetType
				+ ", price=" + price + ", purchaseDate=" + purchaseDate + ", expireDate=" + expireDate + "]";
	}
	
	
}
