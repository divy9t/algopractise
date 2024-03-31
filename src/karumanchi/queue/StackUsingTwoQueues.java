package karumanchi.queue;

public class StackUsingTwoQueues {
    CircularQueueImplementation pushStack;
    CircularQueueImplementation popStack;

    public StackUsingTwoQueues(Integer capacity) {
        this.pushStack = new CircularQueueImplementation(capacity);
        this.popStack = new CircularQueueImplementation(capacity);
    }


    void push(int element) {
        pushStack.enqueue(element);
    }

    int pop() {
        if (pushStack.getSize() == 1)
            return pushStack.dequeue();
        if (popStack.isEmpty())
            pushElementsToPopStack();
        return popStack.dequeue();
    }

    private void pushElementsToPopStack() {
        if (pushStack.isEmpty())
            return;
        int dequeue = pushStack.dequeue();
        pushElementsToPopStack();
        popStack.enqueue(dequeue);

    }


    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
