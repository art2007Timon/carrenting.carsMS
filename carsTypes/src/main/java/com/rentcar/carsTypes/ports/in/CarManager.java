package com.rentcar.carsTypes.ports.in;

import com.rentcar.carsTypes.ports.data.Car;

import java.util.List;
import java.util.Optional;

public interface CarManager {
    Car addCar(Car car);
    List<Car> getAllCars();

    Car updateCar(String kennzeichen, Car car);
    void deleteCarByKennzeichen(String kennzeichen);

    Optional<Car> getCar(String kennzeichen);

}
