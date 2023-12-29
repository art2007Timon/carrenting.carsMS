package com.carrenting.car.ports.in;

import com.carrenting.car.ports.data.Car;

import java.util.List;
import java.util.Optional;

public interface CarManager {
    Car addCar(Car car);
    List<Car> getAllCars();
    Car updateCar(String licensePlate, Car car);
    void deleteCarByLicensePlate(String licensePlate);
    Optional<Car> getCar(String licensePlate);
}
