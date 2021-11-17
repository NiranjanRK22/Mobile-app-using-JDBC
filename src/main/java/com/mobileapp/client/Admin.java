package com.mobileapp.client;

import java.util.Scanner;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

public class Admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        IMobileService mobileService = new MobileServiceImpl();
        Scanner sc = new Scanner(System.in);
        Mobile mobile = new Mobile();
//        System.out.println("Enter model: ");
//        String model = sc.next();
//        mobile.setModel(model);
//        System.out.println("Enter brand: ");
//        String brand = sc.next();
//        mobile.setBrand(brand);
//        System.out.println("Enter os: ");
//        String os = sc.next();
//        mobile.setOs(os);
//        System.out.println("Enter price: ");
//        Double price = sc.nextDouble();
//        mobile.setPrice(price);
//        System.out.println("Enter storage: ");
//        String storage = sc.next();
//        mobile.setStorage(storage);     
        
        //mobileService.addMobile(mobile);
        
        //mobileService.getAllMobiles().forEach(System.out::println);
		/*
		 * try { System.out.println(mobileService.getById(2)); } catch
		 * (IdNotFoundException e1) { System.out.println(e1.getMessage()); }
		 */
		/*
		 * try { System.out.println(mobileService.getByBrand("iphone")); } catch
		 * (MobileNotFoundException e1) { System.out.println(e1.getMessage()); }
		 */
        try {
			System.out.println(mobileService.getByBrandAndModel("iphone", "i11"));
		} catch (MobileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
        try {
			System.out.println(mobileService.getByLesserPrice(30000));
		} catch (MobileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
        try {
			System.out.println(mobileService.getByOs("ios"));
		} catch (MobileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
        
        try  {
        	mobileService.deleteMobile(1);
        }
       catch(IdNotFoundException e)  {
       	   System.out.println(e.getMessage());
        }
        
        try {
        	mobileService.updateMobile(1, 3000);
        }
        catch(IdNotFoundException e)  {
        	System.out.println(e.getMessage());
        }
	}

}

