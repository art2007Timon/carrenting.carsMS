package com.rentcar.carsTypes.ports.out;

import com.rentcar.carsTypes.ports.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository: упрощения операций с базой данных, обеспечивая встроенную поддержку сортировки, а также автоматическую генерацию запросов на основе имен методов.
//Методы JpaRepository генерируют запросы к базам данных
public interface CarRepository extends JpaRepository<Car, Long> {
    // Метод для поиска автомобилей по марке
    List<Car> findByMarke(String marke);

    // Метод для поиска автомобилей по модели
    List<Car> findByModell(String modell);

    // Метод для поиска автомобилей по их регистрационному номеру
    Car findByKennzeichen(String kennzeichen);

    // Метод для поиска автомобилей по статусу резервирования
    List<Car> findByReserved(boolean reserved);

    // Метод для поиска автомобилей по id
    Car findById(long id);

}