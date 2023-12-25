package com.rentcar.carsTypes.ports.out;

import com.rentcar.carsTypes.ports.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//stellt Methoden zur Interaktion mit der Datenbank bereit.
public interface CarRepository extends JpaRepository<Car, Long> {
    void deleteByKennzeichen(String kennzeichen);
    Optional<Car> findByKennzeichen(String kennzeichen);


    //-----------------[OPTIONAL]----------------------------------------------
    List<Car> findByMarke(String marke);

    List<Car> findByModell(String modell);

/*  Car findByKennzeichen(String kennzeichen);*/

    List<Car> findByReserved(boolean reserved);
}
