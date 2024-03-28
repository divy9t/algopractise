package karumanchi.queue;

public class ReverseQueue {

    public static void main(String[] args) {

        CircularQueueImplementation queueImplementation = new CircularQueueImplementation(5);
        queueImplementation.enqueue(1);
        queueImplementation.enqueue(2);
        queueImplementation.enqueue(3);
        queueImplementation.enqueue(4);
        queueImplementation.enqueue(5);
        queueImplementation.printQueue();
        reverseQueue(queueImplementation);
        queueImplementation.printQueue();
    }

    // 1, 2, 3, 4, 5
    private static void reverseQueue(CircularQueueImplementation queueImplementation) {
        if (queueImplementation.isEmpty())
            return;

        int dequeueElement = queueImplementation.dequeue();
        reverseQueue(queueImplementation);
        queueImplementation.enqueue(dequeueElement);
    }

}
