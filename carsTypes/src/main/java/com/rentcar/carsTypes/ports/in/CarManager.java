package com.rentcar.carsTypes.ports.in;

import com.rentcar.carsTypes.ports.data.Car;

import java.util.List;

public interface CarManager {
    Car addCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}
