import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите IP-адрес: ");
        String ip = scanner.nextLine();

        try {
            if (isValidIP(ip)) {
                System.out.println("IP-адрес корректный.");
            } else {
                System.out.println("IP-адрес некорректный.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static boolean isValidIP(String ip) {
        // Регулярное выражение для IP-адреса
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = "^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
