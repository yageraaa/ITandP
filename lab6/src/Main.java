import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SalesManager salesManager = new SalesManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Добро пожаловать в систему учета продаж!");

        while (!exit) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить проданный товар");
            System.out.println("2. Вывести список проданных товаров");
            System.out.println("3. Посчитать общую сумму продаж");
            System.out.println("4. Определить наиболее популярный товар");
            System.out.println("5. Выйти");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Добавление товара
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();

                    double price;
                    System.out.print("Введите цену товара: ");
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                        if (price < 0) {
                            System.out.println("Ошибка: цена не может быть отрицательной.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: некорректный формат цены.");
                        break;
                    }

                    int quantity;
                    System.out.print("Введите количество проданных единиц: ");
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity <= 0) {
                            System.out.println("Ошибка: количество должно быть положительным числом.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: некорректный формат количества.");
                        break;
                    }

                    salesManager.addProduct(name, price, quantity);
                    System.out.println("Товар успешно добавлен.");
                    break;

                case 2:
                    // Вывод списка товаров
                    salesManager.displaySoldProducts();
                    break;

                case 3:
                    // Подсчет общей суммы продаж
                    double totalSales = salesManager.calculateTotalSales();
                    System.out.printf("Общая сумма продаж: %.2f%n", totalSales);
                    break;

                case 4:
                    // Определение популярного товара
                    Product popularProduct = salesManager.getMostPopularProduct();
                    if (popularProduct != null) {
                        System.out.println("Наиболее популярный товар:");
                        System.out.printf("%s | Продано: %d единиц%n", popularProduct.getName(), popularProduct.getQuantity());
                    } else {
                        System.out.println("Список проданных товаров пуст.");
                    }
                    break;

                case 5:
                    // Выход из программы
                    exit = true;
                    System.out.println("Программа завершена. До свидания!");
                    break;

                default:
                    System.out.println("Ошибка: введите число от 1 до 5.");
                    break;
            }
        }
        scanner.close();
    }
}
