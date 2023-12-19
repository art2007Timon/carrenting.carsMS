package com.rentcar.carsTypes.ports.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marke;
    private String modell;
    private String kennzeichen;
    private boolean reserved;
    private int kilometerstand;

    // Конструкторы
    public Car() {}

    public Car(String marke, String modell, String kennzeichen, boolean reserved, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.kennzeichen = kennzeichen;
        this.reserved = reserved;
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




    // Getters_Setters
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


    //reservieren
    public void setReservation( boolean bul) {
        this.reserved = bul;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }
}

/*
    Экспликация аннотаций JPA:
@Entity: Эта аннотация указывает, что класс является сущностью JPA, что означает его прямое соответствие
        таблице в базе данных.
@Id: Указывает, что поле id является первичным ключом этой сущности.
@GeneratedValue(strategy = GenerationType.IDENTITY): Определяет стратегию генерации идентификаторов.
        В данном случае используется IDENTITY, что означает, что идентификатор будет генерироваться
        автоматически средствами базы данных.*/
