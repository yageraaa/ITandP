package task3;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class Warehouse {
    private Queue<Product> products = new ConcurrentLinkedQueue<>();

    public Warehouse(List<Product> products) {
        this.products.addAll(products);
    }

    public synchronized Product loadProduct() {
        if (products.isEmpty()) return null;
        return products.poll();
    }

    public boolean hasProducts() {
        return !products.isEmpty();
    }
}