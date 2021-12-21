package com.mobileapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exception.IdNotFoundException;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.repository.IMobileRepository;
import com.mobileapp.repository.MobileRepositoryImpl;

public class MobileServiceImpl implements IMobileService {
    IMobileRepository mobileRepository = new MobileRepositoryImpl();
	@Override
	public void addMobile(Mobile mobile) {
		mobileRepository.addMobile(mobile);

	}

	@Override
	public void updateMobile(int mobileId, double price) throws IdNotFoundException {
		mobileRepository.updateMobile(mobileId, price);

	}

	@Override
	public Mobile getById(int mobileId) throws IdNotFoundException {
		return mobileRepository
				.findById(mobileId);
	}

	@Override
	public void deleteMobile(int mobileId) throws IdNotFoundException {
		mobileRepository.deleteMobile(mobileId);

	}

	@Override
	public List<Mobile> getAllMobiles() {
		
		return mobileRepository
				.findAllMobiles()
				.stream()
				.sorted((o1, o2) -> o1.getModel().compareTo(o2.getModel()))
				.collect(Collectors.toList());		
				
	}

	@Override
	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {
		return mobileRepository.findByBrand(brand).stream()
				.sorted((o1, o2) -> o1.getModel().compareTo(o2.getModel()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getByBrandAndModel(String brand, String model) throws MobileNotFoundException {
		return mobileRepository.findByBrandAndModel(brand, model).stream()
				.sorted((o1, o2) -> o1.getModel().compareTo(o2.getModel()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getByOs(String os) throws MobileNotFoundException {
		return mobileRepository.findByOs(os).stream()
				.sorted((o1, o2) -> o1.getModel().compareTo(o2.getModel()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Mobile> getByLesserPrice(double lowPrice) throws MobileNotFoundException {
		return mobileRepository.findByLesserPrice(lowPrice).stream()
				.sorted((o1, o2) -> o1.getModel().compareTo(o2.getModel()))
				.collect(Collectors.toList());
	}

}
