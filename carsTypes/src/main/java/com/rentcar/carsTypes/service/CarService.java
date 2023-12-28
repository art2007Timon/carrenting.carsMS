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
    @Transactional                  //Entweder Transaktion durchgefuehrt oder Rollback (Falls Fehler auftritt)
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(String licensePlate, Car updatedCarData) {
        Car existingCar = carRepository.findByLicensePlate(licensePlate)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        existingCar.setMileage(updatedCarData.getMileage());
        return carRepository.save(existingCar);
    }

    @Override
    @Transactional
    public void deleteCarByLicensePlate(String licensePlate) {
        carRepository.deleteByLicensePlate(licensePlate);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Car> getCar(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }
}
