import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpperCaseAfterLowerCase {
    public static void main(String[] args) {
        String text = "This is aSample text where weFind lowercase followed by UppercaseLetters.";

        try {
            String regex = "([a-z])([A-Z])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String replacement = matcher.group(1) + "!" + matcher.group(2) + "!";
                matcher.appendReplacement(result, replacement);
            }
            matcher.appendTail(result);

            System.out.println("Результат:");
            System.out.println(result.toString());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
