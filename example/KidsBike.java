package org.example;

import org.springframework.stereotype.Component;

@Component("kidsBike")
public class KidsBike {
    private final String brand = "Aspect";
    private final int wheelSize = 16;

    public void info() {
        System.out.println("Детский велосипед: " + brand + ", размер колёс: " + wheelSize);
    }
}
