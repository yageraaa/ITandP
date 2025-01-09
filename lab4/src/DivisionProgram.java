import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DivisionProgram {
    public static void main(String[] args) {
        double numerator = 10;    // Числитель
        double denominator = 0;   // Знаменатель (установлен в 0 для демонстрации исключения)

        try {
            double result = divide(numerator, denominator);
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            System.out.println("Произошло исключение: " + e.getMessage());
            logException(e);
        }
    }

    // Метод деления двух чисел
    public static double divide(double a, double b) throws CustomDivisionException {
        if (b == 0) {
            throw new CustomDivisionException("Деление на ноль невозможно.");
        }
        return a / b;
    }

    // Метод логирования исключений в файл
    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("exceptions.log", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Исключение: " + e.toString());
        } catch (IOException ioe) {
            System.out.println("Ошибка при записи в лог-файл: " + ioe.getMessage());
        }
    }
}
