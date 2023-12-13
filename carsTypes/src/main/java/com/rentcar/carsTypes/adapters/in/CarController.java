package com.rentcar.carsTypes.adapters.in;

import com.rentcar.carsTypes.ports.data.Car;
import com.rentcar.carsTypes.ports.in.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarManager carManager;    //Interface -> port.in

    @Autowired
    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }

    // обрабатывает POST-запросы для добавления новых автомобилей.
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carManager.addCar(car);
        return ResponseEntity.ok(newCar);
    }

    //обрабатывает GET-запросы для получения списка всех автомобилей.
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carManager.getAllCars();
        return ResponseEntity.ok(cars);
    }

    //обрабатывает GET-запросы для получения информации об определенном автомобиле по его идентификатору.
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carManager.getCarById(id);
        return ResponseEntity.ok(car);
    }

    //обрабатывает PUT-запросы для обновления информации об автомобиле.
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updatedCar = carManager.updateCar(id, car);
        return ResponseEntity.ok(updatedCar);
    }

    //обрабатывает DELETE-запросы для удаления автомобиля.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carManager.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
