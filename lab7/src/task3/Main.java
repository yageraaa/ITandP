package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(50));
        products.add(new Product(30));
        products.add(new Product(70));
        products.add(new Product(20));
        products.add(new Product(60));
        products.add(new Product(40));
        products.add(new Product(80));
        products.add(new Product(10));
        products.add(new Product(90));
        products.add(new Product(100));


        Warehouse warehouse = new Warehouse(products);
        Loader loader1 = new Loader(warehouse, "Грузчик 1");
        Loader loader2 = new Loader(warehouse, "Грузчик 2");
        Loader loader3 = new Loader(warehouse, "Грузчик 3");

        loader1.start();
        loader2.start();
        loader3.start();
    }
}
