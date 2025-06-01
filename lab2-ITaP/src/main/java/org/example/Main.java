package org.example;

public class Main {
    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike("Stark", 27, 11.8, "Одноподвесная");
        KidsBike kidsBike = new KidsBike("Aspect", 7, 7.5, 16);
        BMXBike bmxBike = new BMXBike("Haro", 1, 10.2, true);

        System.out.println("Горный велосипед: " +
                mountainBike.getBrand() + ", скоростей: " +
                mountainBike.getNumberOfGears() + ", вес: " +
                mountainBike.getWeight() + ", тип подвески: " +
                mountainBike.getSuspensionType());
        mountainBike.ride();
        mountainBike.jump();

        System.out.println();

        System.out.println("Детский велосипед: " +
                kidsBike.getBrand() + ", скоростей: " +
                kidsBike.getNumberOfGears() + ", вес: " +
                kidsBike.getWeight() + ", диаметр колес: " +
                kidsBike.getWheelSize());
        kidsBike.ride();
        kidsBike.ringBell();

        System.out.println();

        System.out.println("BMX велосипед: " +
                bmxBike.getBrand() + ", скоростей: " +
                bmxBike.getNumberOfGears() + ", вес: " +
                bmxBike.getWeight() + ", пеги: " +
                bmxBike.isHasPegs());
        bmxBike.ride();
        bmxBike.barspin();

        System.out.println();

        System.out.println("Создано горных велосипедов: " + MountainBike.getMountainBikeCount());
    }
}
