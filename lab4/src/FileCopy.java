import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Имена исходного и целевого файлов
        String sourceFile = "source.txt";
        String targetFile = "target.txt";

        // Используем конструкцию try-with-resources для автоматического закрытия потоков
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            // Читаем из исходного файла и пишем в целевой файл
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено успешно.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
