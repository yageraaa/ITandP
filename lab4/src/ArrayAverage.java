public class ArrayAverage {
    public static void main(String[] args) {
        // Создаем массив строк, некоторые из которых не являются числами
        String[] arr = {"1", "2", "three", "4", "5"};
        int sum = 0;
        double average = 0;

        try {
            for (int i = 0; i <= arr.length; i++) { // намеренно используем <= чтобы вызвать исключение
                int num = Integer.parseInt(arr[i]); // может вызвать NumberFormatException
                sum += num;
            }
            average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом. " + e.getMessage());
        }
    }
}
