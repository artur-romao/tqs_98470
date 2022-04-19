package com.lab3.ex2.controller;

import java.util.List;

import com.lab3.ex2.data.Car;
import com.lab3.ex2.data.CarRequestModel;
import com.lab3.ex2.service.CarManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    
    @Autowired
    private CarManagerService carManagerService;
    
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody CarRequestModel carRequestModel) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carManagerService.save(new Car(carRequestModel.getMaker(), carRequestModel.getModel()));
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping(path="/cars" )
    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    @GetMapping(path="/cars/{carId}" )
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        return ResponseEntity.of(carManagerService.getCarDetails(carId));
    }
}
