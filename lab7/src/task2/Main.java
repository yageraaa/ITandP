package task2;

public class Main {
    public static void main(String[] args) {
        // Инициализируем матрицу
        int[][] matrix = {
                {3, 5, 1, 7},
                {6, 10, 2, 4},
                {9, 8, 11, 1},
                {1, 4, 7, 12}
        };

        MaxFindingThread[] threads = new MaxFindingThread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new MaxFindingThread(matrix[i]);
            threads[i].start();
        }

        int globalMax = Integer.MIN_VALUE;

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
                int maxInRow = threads[i].getMaxInRow();
                if (maxInRow > globalMax) {
                    globalMax = maxInRow;
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }
}
