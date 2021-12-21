package com.mobileapp.client;

import java.util.Scanner;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

public class Admin {

	public static void main(String[] args) {
        IMobileService mobileService = new MobileServiceImpl();
        Scanner sc = new Scanner(System.in);
        Mobile mobile = new Mobile();
        System.out.println("Select the option");
        System.out.println("1.Add mobiles 2. View all mobiles 3. View mobiles by id 4. View mobiles by brand 5.View mobiles by brand and model");
        System.out.println("6. View mobiles by lesser price 7. View mobiles by OS 8. Update mobile price 9. Delete mobile");
        int option = sc.nextInt();
        switch(option)  {
        case 1:
        	for(int i=0; i<2; i++)  {
        	System.out.println("Enter model: ");
            String model = sc.next();
            mobile.setModel(model);
            System.out.println("Enter brand: ");
            String brand = sc.next();
            mobile.setBrand(brand);
            System.out.println("Enter os: ");
            String os = sc.next();
            mobile.setOs(os);
            System.out.println("Enter price: ");
            Double price = sc.nextDouble();
            mobile.setPrice(price);
            System.out.println("Enter storage: ");
            String storage = sc.next();
            mobile.setStorage(storage); 
            mobileService.addMobile(mobile);
        }   
            break;
        case 2:
        	mobileService.getAllMobiles().forEach(System.out::println);
        	break;
        case 3:
        	try { 
   			 System.out.println(mobileService.getById(3)); 
   		    } catch (IdNotFoundException e1) { 
   			 System.out.println(e1.getMessage()); 
   		    }
        	break;
        case 4:
        	try {
  			  System.out.println(mobileService.getByBrand("iphone")); 
  			  } 
  		  catch (MobileNotFoundException e1) { 
  				  System.out.println(e1.getMessage()); 
  			  }
        	break;
        case 5:
        	try {
    			System.out.println(mobileService.getByBrandAndModel("iphone", "i11"));
    		} catch (MobileNotFoundException e1) {
    			System.out.println(e1.getMessage());
    		}
        	break;
        case 6:
        	try {
    			System.out.println(mobileService.getByLesserPrice(30000));
    		} catch (MobileNotFoundException e1) {
    			System.out.println(e1.getMessage());
    		}
        	break;
         case 7:
        	 try {
     			System.out.println(mobileService.getByOs("ios"));
     		} catch (MobileNotFoundException e1) {
     			System.out.println(e1.getMessage());
     		}
        	break;
         case 8:
        	 try {
             	mobileService.updateMobile(3, 30000);
             }
             catch(IdNotFoundException e)  {
             	System.out.println(e.getMessage());
             }
        	 break;
         case 9:
        	 try  {
             	mobileService.deleteMobile(1);
             }
            catch(IdNotFoundException e)  {
            	   System.out.println(e.getMessage());
             }
        	 break;
        }
           
        
	}

}

