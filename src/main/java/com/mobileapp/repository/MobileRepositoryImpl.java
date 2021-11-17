package com.mobileapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileRepositoryImpl implements IMobileRepository {
    static Connection connection;
	@Override
	public void addMobile(Mobile mobile) {
		PreparedStatement statement = null;
		try  {
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(Queries.InsertQuery);
			statement.setString(1, mobile.getModel());
			statement.setString(2, mobile.getBrand());
			statement.setString(3, mobile.getOs());
			statement.setDouble(4,  mobile.getPrice());
			statement.setString(5, mobile.getStorage());
			statement.execute();
			
		}
		catch(SQLException e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		

	}

	@Override
	public void updateMobile(int mobileId, double price) throws IdNotFoundException {
		PreparedStatement statement = null;
		try  {
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(Queries.UpdateQuery);
			statement.setInt(1, mobileId);
			statement.setDouble(2, price);
			boolean result = statement.execute();
			System.out.println(result);
		}
		catch(Exception e)  {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)  {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}
		}

	}

	@Override
	public Mobile findById(int mobileId) throws IdNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		Mobile mobile = null;
		//List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.SelectByIdQuery);
		statement.setInt(1, mobileId);
		resultset = statement.executeQuery();
		while (resultset.next())  {
			mobile = new Mobile();
			mobile.setBrand(resultset.getString("brand"));
			mobile.setModel(resultset.getString("model"));
			mobile.setStorage(resultset.getString("storage"));
			mobile.setMobileId(resultset.getInt("mobileid"));
			mobile.setOs(resultset.getString("os"));
			mobile.setPrice(resultset.getDouble("price"));
			
		}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return mobile;
	}

	@Override
	public void deleteMobile(int mobileId) throws IdNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		try  {
			statement = connection.prepareStatement(Queries.DeleteQuery);
			statement.setInt(1,  mobileId);
			boolean result = statement.execute();
			System.out.println(result);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}
       
	}

	@Override
	public List<Mobile> findAllMobiles() {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.SelectAllQuery);
		resultset = statement.executeQuery();
		while (resultset.next())  {
			String model = resultset.getString("model");
			String brand = resultset.getString("brand");
			String storage = resultset.getString("storage");
			String os = resultset.getString("os");
			double price = resultset.getDouble("price");
			Mobile mobile = new Mobile(model, brand, storage, os, price);
			mobileList.add(mobile);
		}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();
		}
		
		return mobileList;
	}

	@Override
	public List<Mobile> findByBrand(String brand) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.GetByBrandQuery);
		statement.setString(1, brand);
		resultset = statement.executeQuery();
		while (resultset.next())  {
			String model = resultset.getString("model");
			String brand1 = resultset.getString("brand");
			String storage = resultset.getString("storage");
			String os = resultset.getString("os");
			double price = resultset.getDouble("price");
			Mobile mobile = new Mobile(model, brand1, storage, os, price);
			mobile.setMobileId(resultset.getInt("mobileId"));
			mobileList.add(mobile);

		}
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("brand not found");
		}	
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByBrandAndModel(String brand, String model) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.GetByBrandModelQuery);
		statement.setString(1, brand);
		statement.setString(2, model + "%");
		resultset = statement.executeQuery();
		while (resultset.next())  {
			String model1 = resultset.getString("model");
			String brand1 = resultset.getString("brand");
			String storage = resultset.getString("storage");
			String os = resultset.getString("os");
			double price = resultset.getDouble("price");
			Mobile mobile = new Mobile(model1, brand1, storage, os, price);
			mobile.setMobileId(resultset.getInt("mobileId"));
			mobileList.add(mobile);

		}
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("mobile with this brand not found");
		}
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByOs(String os) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.GetByOsQuery);
		statement.setString(1, os);
		resultset = statement.executeQuery();
		while (resultset.next())  {
			String model = resultset.getString("model");
			String brand1 = resultset.getString("brand");
			String storage = resultset.getString("storage");
			String os1 = resultset.getString("os");
			double price = resultset.getDouble("price");
			Mobile mobile = new Mobile(model, brand1, storage, os1, price);
			mobile.setMobileId(resultset.getInt("mobileId"));
			mobileList.add(mobile);

		}
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("brand not found");
		}
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByLesserPrice(double lowPrice) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();
		try  {
		statement = connection.prepareStatement(Queries.GetByPriceQuery);
		statement.setDouble(1, lowPrice);
		resultset = statement.executeQuery();
		while (resultset.next())  {
			String model = resultset.getString("model");
			String brand1 = resultset.getString("brand");
			String storage = resultset.getString("storage");
			String os = resultset.getString("os");
			double price = resultset.getDouble("price");
			Mobile mobile = new Mobile(model, brand1, storage, os, price);
			mobile.setMobileId(resultset.getInt("mobileId"));
			mobileList.add(mobile);

		}
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("mobile not found lesser than the price");
		}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ModelDAO.closeConnection();

		}
		return mobileList;
	}

}
