package org.example;

import org.springframework.stereotype.Component;

@Component("bmxBike")
public class BMXBike {
    private final String brand = "Haro";
    private final boolean hasPegs = true;

    public void info() {
        System.out.println("BMX велосипед: " + brand + ", пеги: " + (hasPegs ? "есть" : "нет"));
    }
}
