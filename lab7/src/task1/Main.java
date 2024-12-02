package task1;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        // Задать начальные и конечные индексы для каждого из потоков.
        int mid = array.length / 2;

        SumThread t1 = new SumThread(array, 0, mid);
        SumThread t2 = new SumThread(array, mid, array.length);

        t1.start();
        t2.start();

        // Ожидание завершения работы каждого из потоков.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Суммирование результатов.
        long totalSum = t1.getSum() + t2.getSum();
        System.out.println("Общая сумма: " + totalSum);
    }
}
