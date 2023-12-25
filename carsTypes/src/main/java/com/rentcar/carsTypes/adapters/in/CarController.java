package com.rentcar.carsTypes.adapters.in;

import com.rentcar.carsTypes.ports.data.Car;
import com.rentcar.carsTypes.ports.in.CarManager;
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

    //POST: http://localhost:8080/api/cars
    //JSON: {"id": 7, "marke": "Honda", "modell": "Accord",    "kennzeichen": "HA1234",   "reserved": false,   "kilometerstand": 22000 }
    @PostMapping//JSON
    public ResponseEntity<Car> addCar(@RequestBody Car car) {   //@RequestBody для входящих JSON данных, которые вводим в body в postman //ResponseEntity<T> для возвращаемых JSON данных
        Car newCar = carManager.addCar(car);
        return ResponseEntity.ok(newCar);
    }

    //GET: http://localhost:8080/api/cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carManager.getAllCars();
        return ResponseEntity.ok(cars);
    }



    //PUT: http://localhost:8080/api/cars/FRM10
    //JSON: { "kennzeichen": "FRM10", "kilometerstand": 25000, "reserved": true }
    @PutMapping("/{kennzeichen}")
    public ResponseEntity<Car> updateCar(@PathVariable String kennzeichen, @RequestBody Car car) {
        Car updatedCar = carManager.updateCar(kennzeichen, car);
        return ResponseEntity.ok(updatedCar);
    }

    //DELETE: http://localhost:8080/api/cars/HA1234
    @DeleteMapping("/{kennzeichen}")
    public ResponseEntity<Void> deleteCar(@PathVariable String kennzeichen) {
        carManager.deleteCarByKennzeichen(kennzeichen);
        return ResponseEntity.ok().build();
    }

    //GET: http://localhost:8080/api/cars/HA1234
    @GetMapping("/{kennzeichen}")
    public ResponseEntity<Car> getCar(@PathVariable String kennzeichen) {
        Optional<Car> car = carManager.getCar(kennzeichen);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
