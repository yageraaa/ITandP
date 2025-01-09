import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            System.out.println("Пароль корректен.");
        } catch (InvalidPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        // Проверка длины пароля
        if (password.length() < 8 || password.length() > 16) {
            throw new InvalidPasswordException("Пароль должен быть длиной от 8 до 16 символов.");
        }

        // Регулярное выражение для проверки пароля
        String regex = "^(?=.*[0-9])(?=.*[A-Z])[A-Za-z0-9]{8,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new InvalidPasswordException("Пароль должен содержать только латинские буквы и цифры, " +
                    "иметь хотя бы одну заглавную букву и одну цифру.");
        }
    }
}

// Кастомное исключение для некорректного пароля
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
