import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99, and the discount is 15% starting from 1st October.";

        try {
            // Регулярное выражение для поиска чисел (целых и с дробной частью)
            Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа в тексте:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
        }
    }
}
