class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail = -1;
    private int size = 0;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int val) {
        if (!isFull()) {
            tail = (tail + 1) % data.length;
            data[tail] = val;
            size++;
            return true;
        } else
            return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            head = (head + 1) % data.length;
            size--;
            return true;
        } else
            return false;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}