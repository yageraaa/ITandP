package task3;

class Loader extends Thread {
    private Warehouse warehouse;
    private int carriedWeight = 0;

    public Loader(Warehouse warehouse, String name) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (warehouse.hasProducts()) {
            Product product = warehouse.loadProduct();
            if (product != null) {
                carriedWeight += product.getWeight();
                System.out.println(getName() + " взял товар весом " + product.getWeight() + " кг.");
                if (carriedWeight >= 150) {
                    deliverProducts();
                }
            }
        }
        System.out.println(getName() + " закончил работу."); //Добавил для контроля завершения работы
    }

    private void deliverProducts() {
        System.out.println(getName() + " доставляет " + carriedWeight + " кг.");
        carriedWeight = 0;
    }
}

