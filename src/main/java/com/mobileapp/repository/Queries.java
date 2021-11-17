package com.mobileapp.repository;

public class Queries {
       public static final String InsertQuery="insert into mobile(model, brand, os, price, storage) values(?,?,?,?,?)";
       public static final String UpdateQuery="update mobile set price=? where mobileid=?";
       public static final String DeleteQuery="delete from mobile where mobileid=?";
       public static final String SelectAllQuery="select * from mobile";
       public static final String SelectByIdQuery="select * from mobile where mobileid=?";
       public static final String GetByBrandQuery="select * from mobile where brand=?";
       public static final String GetByBrandModelQuery="select * from mobile where brand=? and model like ?";
       public static final String GetByPriceQuery="select * from mobile where price<?";
       public static final String GetByOsQuery="select * from mobile where os=?";
}
