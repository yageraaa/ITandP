package org.example;

public class MountainBike extends Bicycle {
    private String suspensionType;
    private static int mountainBikeCount = 0;

    public MountainBike(String brand, int numberOfGears, double weight, String suspensionType) {
        super(brand, numberOfGears, weight);
        this.suspensionType = suspensionType;
        mountainBikeCount++;
    }

    public MountainBike() {
        this("Default", 21, 12.0, "Одноподвесная");
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    @Override
    public void ride() {
        System.out.println("Горный велосипед едет в гору");
    }

    public void jump() {
        System.out.println("Горный велосипед прыгает");
    }

    public static int getMountainBikeCount() {
        return mountainBikeCount;
    }
}
