public class MyCircularQueue {

    private int[] elements;

    private int front;

    private int tail;

    private int size;

    public MyCircularQueue(int k) {
        elements = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[tail] = value;
        tail++;
        tail %= elements.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front++;
        front %= elements.length;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : elements[front];

    }

    public int Rear() {
        int index = (tail + elements.length - 1) % elements.length;
        return isEmpty() ? -1 : elements[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
}
