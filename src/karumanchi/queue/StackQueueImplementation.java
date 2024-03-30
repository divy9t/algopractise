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

        System.out.println("\n-----------------------------\n");

        QueueImplementationUsingOneStack queueImplementationUsingOneStack = new QueueImplementationUsingOneStack(new Stack<>());
        queueImplementationUsingOneStack.enqueue(1);
        queueImplementationUsingOneStack.enqueue(2);
        queueImplementationUsingOneStack.enqueue(3);
        queueImplementationUsingOneStack.enqueue(4);
        queueImplementationUsingOneStack.enqueue(5);
        System.out.println(queueImplementationUsingOneStack.dequeue());
        System.out.println(queueImplementationUsingOneStack.dequeue());

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

class QueueImplementationUsingOneStack {

    public final Stack<Integer> stack;

    public QueueImplementationUsingOneStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    void enqueue (Integer val) {
        stack.push(val);
    }

    Integer dequeue () {
        if (stack.isEmpty())
            return null;

        Integer val = stack.pop();
        if (stack.isEmpty())
            return val;
        Integer result = dequeue();
        stack.push(val);
        return result;
    }
}
