package com.rentcar.carsTypes.service;

import com.rentcar.carsTypes.ports.data.Car;
import com.rentcar.carsTypes.ports.in.CarManager;
import com.rentcar.carsTypes.ports.out.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarManager {

    @Autowired
    private CarRepository carRepository;

    @Override
    @Transactional  //используется для обозначения методов, которые должны выполняться в рамках транзакции.
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional(readOnly = true) //используется для методов, которые только читают данные и не изменяют их
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    //@Transactional
    public Car updateCar(String kennzeichen, Boolean reserved, Integer kilometerstand) {
        Car car = carRepository.findByKennzeichen(kennzeichen).orElseThrow(() -> new RuntimeException("Car not found"));

        if (reserved != null) {
            car.setReservation(reserved);
        }
        if (kilometerstand != null) {
            car.setKilometerstand(kilometerstand);
        }
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteCarByKennzeichen(String kennzeichen) {
        carRepository.deleteByKennzeichen(kennzeichen);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Car> getCar(String kennzeichen) {
       return carRepository.findByKennzeichen(kennzeichen);
    }
}
