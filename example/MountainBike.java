package org.example;

import org.springframework.stereotype.Component;

@Component("mountainBike")
public class MountainBike {
    private final String brand = "Stark";
    private final int gears = 27;
    private final String suspension = "Одноподвесная";

    public void info() {
        System.out.println("Горный велосипед: " + brand + ", передач: " + gears + ", подвеска: " + suspension);
    }
}
