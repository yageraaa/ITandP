import java.util.ArrayList;

public class SalesManager {
    private ArrayList<Product> soldProducts;

    public SalesManager() {
        soldProducts = new ArrayList<>();
    }

    // Добавление товара в список проданных товаров
    public void addProduct(String name, double price, int quantity) {
        // Проверяем, есть ли товар с таким именем и ценой
        for (Product product : soldProducts) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() == price) {
                product.addQuantity(quantity);
                return;
            }
        }
        // Если такого товара нет, добавляем его в список
        soldProducts.add(new Product(name, price, quantity));
    }

    // Вывод списка проданных товаров
    public void displaySoldProducts() {
        if (soldProducts.isEmpty()) {
            System.out.println("Список проданных товаров пуст.");
            return;
        }
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    // Подсчет общей суммы продаж
    public double calculateTotalSales() {
        double total = 0.0;
        for (Product product : soldProducts) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    // Определение наиболее популярного товара
    public Product getMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return null;
        }
        Product mostPopular = soldProducts.get(0);
        for (Product product : soldProducts) {
            if (product.getQuantity() > mostPopular.getQuantity()) {
                mostPopular = product;
            }
        }
        return mostPopular;
    }
}
