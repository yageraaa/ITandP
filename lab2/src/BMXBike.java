public class BMXBike extends Bicycle {
    private boolean hasPegs;

    public BMXBike(String brand, int numberOfGears, double weight, boolean hasPegs) {
        super(brand, numberOfGears, weight);
        this.hasPegs = hasPegs;
    }

    public BMXBike() {
        this("Unknown", 1, 9.0, true);
    }

    public boolean isHasPegs() {
        return hasPegs;
    }

    public void setHasPegs(boolean hasPegs) {
        this.hasPegs = hasPegs;
    }

    @Override
    public void ride() {
        System.out.println("BMX выполняет трюк.");
    }

    public void barspin() {
        System.out.println("BMX вращает руль.");
    }
}