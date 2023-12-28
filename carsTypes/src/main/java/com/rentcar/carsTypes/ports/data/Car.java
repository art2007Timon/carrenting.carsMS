package com.rentcar.carsTypes.ports.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity         //eine Klasse ist eine JPA-Entität, was bedeutet, dass sie direkt mit einer Tabelle in der Datenbank übereinstimmt.
@Getter         //Automatische generierung
@Setter         //Automatische generierung
public class Car {
    @Id         //ID ist der Primärschlüssel dieser Entität.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definiert eine Strategie zur Identitätsgenerierung. In diesem Fall wird IDENTITY verwendet, was bedeutet, dass die ID automatisch von der Datenbank generiert wird.
    private int carID;
    private String brand;
    private String model;
    private String licensePlate;
    private Integer mileage;

    public Car() {}

    public Car(String marke, String modell, String licensePlate, int mileage) {
        this.brand = marke;
        this.model = modell;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }
}