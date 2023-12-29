package com.carrenting.car.ports.out;

import com.carrenting.car.ports.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//stellt Methoden zur Interaktion mit der Datenbank bereit.
public interface CarRepository extends JpaRepository<Car, Long> {
    void deleteByLicensePlate(String licensePlate);
    Optional<Car> findByLicensePlate(String licensePlate);
}
