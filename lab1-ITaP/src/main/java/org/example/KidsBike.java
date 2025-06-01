package org.example;

public class KidsBike extends Bicycle {
    private int wheelSize;

    public KidsBike(String brand, int numberOfGears, double weight, int wheelSize) {
        super(brand, numberOfGears, weight);
        this.wheelSize = wheelSize;
    }

    public KidsBike() {
        this("Unknown", 1, 5.0, 12);
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public void ride() {
        System.out.println("Детский велосипед едет по дорожке.");
    }

    public void ringBell() {
        System.out.println("ЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗЗ");
    }
}
