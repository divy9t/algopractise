package karumanchi.queue;

import java.util.Stack;

public class StackQueueImplementation {

    public static void main(String[] args) {
        StackQueueImplementation stackQueueImplementation = new StackQueueImplementation();
        stackQueueImplementation.enqueue(1);
        stackQueueImplementation.enqueue(2);
        stackQueueImplementation.enqueue(3);
        stackQueueImplementation.enqueue(4);
        stackQueueImplementation.enqueue(5);
        System.out.println(stackQueueImplementation.dequeue());
        System.out.println(stackQueueImplementation.dequeue());
        System.out.println(stackQueueImplementation.dequeue());
    }

    public final Stack<Integer> enqueueStack;
    public final Stack<Integer> dequeueStack;

    public StackQueueImplementation() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    void enqueue (Integer pushElement) {
        enqueueStack.push(pushElement);
    }

    Integer dequeue () {
        if (dequeueStack.isEmpty())
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());

        return dequeueStack.isEmpty() ? null : dequeueStack.pop();
    }


}
