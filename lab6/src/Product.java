public class Product {
    private String name;
    private double price;
    private int quantity;

    // Конструктор
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Увеличение количества проданных товаров
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%s | Цена: %.2f | Количество: %d", name, price, quantity);
    }
}
