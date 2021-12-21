package com.mobileapp.model;
/**
 * 
 * @author NiranjanRamakrishna
 * @version 1.0
 */
public class Mobile {
     private String model;
     private String brand;
     private Integer mobileId;
     private String storage;
     private String os;
     private double price;
     
     public Mobile() {
 		super();
 		
 	}
 	
 	
	/**
	 * @param model
	 * @param brand
	 * @param storage
	 * @param os
	 * @param price
	 */
	public Mobile(String model, String brand, String storage, String os, double price) {
		super();
		this.model = model;
		this.brand = brand;
		this.storage = storage;
		this.os = os;
		this.price = price;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the mobileId
	 */
	public Integer getMobileId() {
		return mobileId;
	}

	/**
	 * @param mobileId the mobileId to set
	 */
	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	/**
	 * @return the storage
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * @param storage the storage to set
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}


	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [model=" + model + ", brand=" + brand + ", mobileId=" + mobileId + ", storage=" + storage
				+ ", os=" + os + ", price=" + price + "]";
	}
	
     
     
}
