package com.mobileapp.repository;

import java.util.List;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileRepository {
	//called by admin
    void addMobile(Mobile mobile);
    void updateMobile(int mobileId, double price) throws IdNotFoundException; 
    Mobile findById(int mobileId) throws IdNotFoundException;
    void deleteMobile(int mobileId) throws IdNotFoundException;
    
    //called by user
    List<Mobile>  findAllMobiles();
    List<Mobile>  findByBrand(String brand) throws MobileNotFoundException;
    List<Mobile>  findByBrandAndModel(String brand, String model) throws MobileNotFoundException;
    List<Mobile>  findByOs(String os) throws MobileNotFoundException;
    List<Mobile>  findByLesserPrice(double lowPrice) throws MobileNotFoundException;
}
