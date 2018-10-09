package com.apap.tutorial5.service;

import java.util.Optional;

import com.apap.tutorial5.model.CarModel;

public interface CarService {
	void addCar(CarModel car);

	void deleteCar(CarModel car);
	
	void updateCar(CarModel car, Long id);
	
	CarModel getCar(Long id);

	Optional<CarModel> getCarDetailById(Long id);
	
}
