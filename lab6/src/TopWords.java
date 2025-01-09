import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указываем путь к файлу
        String filePath = "C:\\text.txt";
        // Создаем объект File
        File file = new File(filePath);
        // Создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            e.printStackTrace();
            return; // Прекращаем выполнение, если файл не найден
        }
        // Создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCounts = new HashMap<>();
        // Читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            // Получаем следующее слово, приводим к нижнему регистру
            String word = scanner.next().toLowerCase();
            // Удаляем знаки препинания и специальные символы
            word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
            if (!word.isEmpty()) {
                // Добавляем слово в Map или обновляем счетчик
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
        }
        // Закрываем Scanner
        scanner.close();
        // Создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
        // Сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // Выводим топ-10 слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < 10 && i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getKey() + " — " + list.get(i).getValue() + " раз(а)");
        }
    }
}
