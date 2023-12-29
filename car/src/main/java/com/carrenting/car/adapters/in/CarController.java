package com.carrenting.car.adapters.in;

import com.carrenting.car.ports.data.Car;
import com.carrenting.car.ports.in.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarManager carManager;    //Interface -> port.in

    @Autowired
    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }

    //GET: http://localhost:8080/api/cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carManager.getAllCars();
        return ResponseEntity.ok(cars);
    }
    //GET: http://localhost:8080/api/cars/RRKHM777
    @GetMapping("/{licensePlate}")
    public ResponseEntity<Car> getCar(@PathVariable String licensePlate) {
        Optional<Car> car = carManager.getCar(licensePlate);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //POST: http://localhost:8080/api/cars
    //JSON: {"licensePlate": "RRKHM777","mileage": 1400,"brand": "PEUGOT","model": "311"} or with carID -> "carID" : 1
    @PostMapping//JSON
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carManager.addCar(car);
        return ResponseEntity.ok(newCar);
    }


    //PUT: http://localhost:8080/api/cars/RRKHM777
    //JSON: {"licensePlate": "RRKHM777","mileage": 1400,"brand": "PEUGOT","model": "311"}
    @PutMapping("/{licensePlate}")
    public ResponseEntity<Car> updateCar(@PathVariable String licensePlate, @RequestBody Car car) {
        Car updatedCar = carManager.updateCar(licensePlate, car);
        return ResponseEntity.ok(updatedCar);
    }


    //DELETE: http://localhost:8080/api/cars/HA1234
    @DeleteMapping("/{licensePlate}")
    public ResponseEntity<Void> deleteCar(@PathVariable String licensePlate) {
        carManager.deleteCarByLicensePlate(licensePlate);
        return ResponseEntity.ok().build();
    }
}
