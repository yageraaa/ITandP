import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsStartingWithLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите букву: ");
        String letter = scanner.nextLine();

        // Проверяем, что введена одна буква
        if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
            System.out.println("Ошибка: необходимо ввести одну букву.");
            return;
        }

        try {
            // Регулярное выражение для слов, начинающихся с заданной буквы
            String regex = "\\b" + Pattern.quote(letter) + "\\w*\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
