package com.lab3.ex2.service;

import java.util.List;
import java.util.Optional;

import com.lab3.ex2.data.Car;
import com.lab3.ex2.data.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {
    @Autowired 
    CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Optional<Car> getCarDetails(Long carId) {
        return carRepository.findByCarId(carId) == null ? Optional.empty() : Optional.of(carRepository.findByCarId(carId));
    }
}
