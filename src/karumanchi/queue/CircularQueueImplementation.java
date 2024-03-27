package karumanchi.queue;

public class CircularQueueImplementation {

    private final int[] queue;
    private int size;
    private int front;
    private int rear;
    private final int capacity;

    public CircularQueueImplementation(int[] queue, int size, int front, int rear, int capacity) {
        this.queue = queue;
        this.size = size;
        this.front = front;
        this.rear = rear;
        this.capacity = capacity;
    }

    public void enqueue (int val) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        queue[rear] = val;
        rear = (rear + 1) % capacity;
        size++;

    }
    public int dequeue () {
        if (isFull()) {
            System.out.println("Underflow");
            return -1;
        }
        int data = queue[front];
        front = (rear + 1) % capacity;
        size--;
        return data;
    }

    public int peek() {
        if (isFull()) {
            System.out.println("Underflow");
            return -1;
        }
        return queue[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
