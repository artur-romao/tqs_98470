package com.lab3.ex2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.lab3.ex2.data.Car;
import com.lab3.ex2.data.CarRepository;
import com.lab3.ex2.service.CarManagerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class B_CarService_UnitTest {
    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carService;

    @BeforeEach
    public void setUp() {

        //these expectations provide an alternative to the use of the repository
        Car car1 = new Car("Volkswagen", "Beetle");
        Car car2 = new Car("Citroen", "Cactus");
        Car car3 = new Car("Nissan", "GTR");

        List<Car> allCars = Arrays.asList(car1, car2, car3);

        when(carRepository.findByCarId(car1.getCarId())).thenReturn(car1);
        when(carRepository.findByCarId(car2.getCarId())).thenReturn(car2);
        when(carRepository.findByCarId(car3.getCarId())).thenReturn(car3);
        when(carRepository.findByCarId(50L)).thenReturn(null);
        when(carRepository.findAll()).thenReturn(allCars);
    }

    @Test
    public void whenSearchValidCar_thenReturnCar() {
        Optional<Car> car = Optional.of(carService.getAllCars().get(0));
        assertEquals("Beetle", car.get().getModel());
        
        verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }

    @Test
    public void whenGetAllCars_thenReturnAllCars() {
        List<Car> allCars = carService.getAllCars();

        assertEquals(3, allCars.size());
        assertEquals("Volkswagen", allCars.get(0).getMaker());
        assertEquals("Citroen", allCars.get(1).getMaker());
        assertEquals("Nissan", allCars.get(2).getMaker());
        
        verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }

    @Test
    public void whenGetCarDetails_ifCarExists_thenReturnCarDetails() {
        Optional<Car> car = Optional.of(carService.getAllCars().get(0));

        assertEquals("Volkswagen", car.get().getMaker());
        assertEquals(false, car.isEmpty());

        verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }

    @Test
    public void whenGetCarDetails_ifCarDoesntExist_thenReturnEmpty() {
        Optional<Car> car = carService.getCarDetails(50L);
        assertEquals(true, car.isEmpty());
        verify(carRepository, VerificationModeFactory.times(1)).findByCarId(50L);
        reset(carRepository);
    }
}
