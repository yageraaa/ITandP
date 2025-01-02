public abstract class Bicycle {
    private String brand;
    private int numberOfGears;
    private double weight;

    public Bicycle(String brand, int numberOfGears, double weight) {
        this.brand = brand;
        this.numberOfGears = numberOfGears;
        this.weight = weight;
    }

    public Bicycle() {
        this("Default", 1, 10.0);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void ride();

    public void brake() {
        System.out.println("Велосипед тормозит");
    }
}