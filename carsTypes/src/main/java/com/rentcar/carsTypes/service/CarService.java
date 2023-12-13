package com.rentcar.carsTypes.service;

import com.rentcar.carsTypes.ports.data.Car;
import com.rentcar.carsTypes.ports.in.CarManager;
import com.rentcar.carsTypes.ports.out.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarManager {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public Car updateCar(Long id, Car updatedCar) {
        Car car = getCarById(id);
        // Обновление атрибутов car с атрибутами updatedCar
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
