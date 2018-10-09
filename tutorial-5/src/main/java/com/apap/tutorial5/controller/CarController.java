package com.apap.tutorial5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tutorial5.model.*;
import com.apap.tutorial5.service.*;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	
	
	@RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
	private String add(@PathVariable (value = "dealerId") Long dealerId, Model model) {
		CarModel car = new CarModel();
		DealerModel dealer  = dealerService.getDealerDetailById(dealerId).get();
		car.setDealer(dealer);
		
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@RequestMapping(value = "/car/add", method = RequestMethod.POST)
	private String addCarSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return "add";
	}
	
	
	@RequestMapping(value = "/car/delete", method = RequestMethod.POST)
	private String delete(@ModelAttribute DealerModel dealer, Model model) {
		for(CarModel car : dealer.getListCar()) {
			carService.deleteCar(car);
		}
		return "delete";
	}
	
	
//	@RequestMapping(value = "/car/delete/{dealerId}", method=RequestMethod.GET)
//	private String deleteCar(@PathVariable(value="dealerId") Long dealerId, Model model) {
//		return "deleteCar";
//	}
//
//	@RequestMapping(value = "/car/delete", method=RequestMethod.POST)
//	private String deleteCarSubmit(String carId, String idDealer) {
//		CarModel car = carService.getCarDetailById(Long.parseLong(carId)).get();
//		carService.deleteCar(car);
//		return "delete";
//	
//	}
	
	@RequestMapping(value = "/car/update/{id}", method = RequestMethod.GET)
	private String updateCar(@PathVariable(value = "id") long id , Model model) {
		CarModel cars = carService.getCar(id);
		model.addAttribute("car", cars);
		return "updateCar";
	}
	
	@RequestMapping(value = "/car/update/{id}" , method = RequestMethod.POST)
	private String updateCarSubmit(@PathVariable(value = "id") long id, @ModelAttribute CarModel car) {
		carService.updateCar(car, id);
		return "update";
	}
}
