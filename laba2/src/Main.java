import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nТаск 1:");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("\nТаск 2:");
        List<List<String>> goods = new ArrayList<>();
        goods.add(Arrays.asList("Laptop", "124200"));
        goods.add(Arrays.asList("Phone", "51450"));
        goods.add(Arrays.asList("Headphones", "13800"));
        System.out.println(sale(goods, 25));

        System.out.println("\nТаск 3:");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println("\nТаск 4:");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("\nТаск 5:");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("\nТаск 6:");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("\nТаск 7:");
        List<List<Object>> inventory = new ArrayList<>();
        inventory.add(Arrays.asList("Скакалка", 550, 8));
        inventory.add(Arrays.asList("Шлем", 3750, 4));
        inventory.add(Arrays.asList("Мяч", 2900, 10));
        System.out.println(mostExpensive(inventory));

        System.out.println("\nТаск 8:");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("\nТаск 9:");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("\nТаск 10:");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }
        return (str1.charAt(0) == str2.charAt(str2.length() - 1) &&
                str1.charAt(str1.length() - 1) == str2.charAt(0));
    }

    public static List<List<String>> sale(List<List<String>> goods, int discount) {
        for (List<String> item : goods) {
            int price = Integer.parseInt(item.get(1));
            int discountedPrice = (int) Math.round(price * (1 - (discount / 100.0)));
            discountedPrice = Math.max(discountedPrice, 1);
            item.set(1, String.valueOf(discountedPrice));
        }
        return goods;
    }

    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2));
        return distance <= r;
    }

    public static boolean parityAnalysis(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        return sum % 2 == n % 2;
    }

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) {
            return "Tie";
        }
        if (p1.equals("rock") && p2.equals("scissors") ||
                p1.equals("scissors") && p2.equals("paper") ||
                p1.equals("paper") && p2.equals("rock")) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }

    public static int bugger(int num) {
        int count = 0;
        while (num > 9) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    public static String mostExpensive(List<List<Object>> inventory) {
        int maxPrice = 0;
        String mostExpensiveItem = "";
        for (List<Object> item : inventory) {
            int price = (int) item.get(1);
            int quantity = (int) item.get(2);
            int totalPrice = price * quantity;
            if (totalPrice > maxPrice) {
                maxPrice = totalPrice;
                mostExpensiveItem = (String) item.getFirst();
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxPrice;
    }

    public static String longestUnique(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            String current = "";
            for (int j = i; j < str.length(); j++) {
                if (current.indexOf(str.charAt(j)) == -1) {
                    current += str.charAt(j);
                } else {
                    break;
                }
            }
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.replace("-", "");
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.replace("-", "");
        return word.endsWith(suffix);
    }


    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w) ||
                (c <= w && a <= h) || (c <= h && a <= w);
    }
}
