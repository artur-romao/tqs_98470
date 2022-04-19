package com.lab3.ex2;

import com.lab3.ex2.data.Car;
import com.lab3.ex2.data.CarRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class C_CarRepository_PersistenceTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenFindBeetleByCarId_thenReturnBeetleCar() {
        // arrange a new employee and insert into db
        Car beetle = new Car("Volkswagen", "Beetle");
        entityManager.persistAndFlush(beetle); //ensure data is persisted at this point

        // test the query method of interest
        Car found = carRepository.findByCarId(beetle.getCarId());
        assertThat( found ).isEqualTo(beetle);
    }

    @Test
    void whenInvalidCarId_thenReturnNull() {
        Car fromDb = carRepository.findByCarId(30L);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenSetOfCars_whenFindAll_thenReturnAllCars() {
        Car beetle = new Car("Volkswagen", "Beetle");
        Car cactus = new Car("Citroen", "Cactus");
        Car gtr = new Car("Nissan", "GTR");

        entityManager.persist(beetle);
        entityManager.persist(cactus);
        entityManager.persist(gtr);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(beetle.getModel(), cactus.getModel(), gtr.getModel());
    }
}
