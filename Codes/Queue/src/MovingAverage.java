import java.util.ArrayDeque;
import java.util.Deque;

class MovingAverage {
    int size;
    int windowSum = 0;
    int count = 0;
    Deque<Integer> queue = new ArrayDeque<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        count++;
        queue.add(val);
        if (count > size && !queue.isEmpty())
            windowSum -= queue.poll();
        windowSum = windowSum + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}