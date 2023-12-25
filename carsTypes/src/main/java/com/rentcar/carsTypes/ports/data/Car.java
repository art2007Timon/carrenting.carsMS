package com.rentcar.carsTypes.ports.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity         //eine Klasse ist eine JPA-Entität, was bedeutet, dass sie direkt mit einer Tabelle in der Datenbank übereinstimmt.
public class Car {
    @Id         //ID ist der Primärschlüssel dieser Entität.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definiert eine Strategie zur Identitätsgenerierung. In diesem Fall wird IDENTITY verwendet, was bedeutet, dass die ID automatisch von der Datenbank generiert wird.
    private Long id;
    private String marke;
    private String modell;
    private String kennzeichen;
    private boolean reserved;
    private int kilometerstand;

    // [Konstruktor]
    public Car() {}

    // Konstruktor
    public Car(String marke, String modell, String kennzeichen, boolean reserved, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.kennzeichen = kennzeichen;
        this.reserved = reserved;
        this.kilometerstand = kilometerstand;
    }

    // [Getters_Setters]
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Reservierungsstatus
    public boolean getReserved() {
        return reserved;
    }

    public void setReservation( boolean bul) {
        this.reserved = bul;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public String getMarke() {
        return marke;
    }
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }
    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }
    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

}