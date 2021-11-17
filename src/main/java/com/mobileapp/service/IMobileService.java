package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {
	//called by admin
      void addMobile(Mobile mobile);
      void updateMobile(int mobileId, double price) throws IdNotFoundException; 
      Mobile getById(int mobileId) throws IdNotFoundException;
      void deleteMobile(int mobileId) throws IdNotFoundException;
      
      //called by user
      List<Mobile>  getAllMobiles();
      List<Mobile>  getByBrand(String brand) throws MobileNotFoundException;
      List<Mobile>  getByBrandAndModel(String brand, String model) throws MobileNotFoundException;
      List<Mobile>  getByOs(String os) throws MobileNotFoundException;
      List<Mobile>  getByLesserPrice(double lowPrice) throws MobileNotFoundException;
}
