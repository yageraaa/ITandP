package task1;

public class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private long sum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public long getSum() {
        return sum;
    }
}