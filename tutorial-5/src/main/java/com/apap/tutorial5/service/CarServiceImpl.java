package com.apap.tutorial5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.repository.CarDb;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarDb carDb;
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
		
	}
	
	@Override
	public void deleteCar(CarModel car) {
		carDb.delete(car);
		
	}
	
	@Override
	public Optional<CarModel> getCarDetailById(Long id){
		return carDb.findById(id);
	}

	@Override
	public void updateCar(CarModel car, Long id) {
		CarModel cars = carDb.getOne(id);
		cars.setBrand(car.getBrand());
		cars.setPrice(car.getPrice());
		cars.setAmount(car.getAmount());
		cars.setType(car.getType());
		carDb.save(cars);
		
	}

	@Override
	public CarModel getCar(Long id) {
		return carDb.findById(id).get();
	}
}
