package task2;

public class MaxFindingThread extends Thread {
    private int[] row;
    private int maxInRow;

    public MaxFindingThread(int[] row) {
        this.row = row;
        this.maxInRow = Integer.MIN_VALUE; // Начальное значение должно быть как можно меньше
    }

    public void run() {
        for (int element : row) {
            if (element > maxInRow) {
                maxInRow = element;
            }
        }
    }

    public int getMaxInRow() {
        return maxInRow;
    }
}