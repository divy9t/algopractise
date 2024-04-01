package karumanchi.queue;

import java.util.LinkedList;

public class QueueFromLinkedList {
    LinkedList<Integer> queue;

    public QueueFromLinkedList() {
        this.queue = new LinkedList<>();
    }

    void enqueue(int val) {
        queue.addLast(val);
    }

    int deQueue () {
        return queue.removeFirst();
    }

    public static void main(String[] args) {
        QueueFromLinkedList queue = new QueueFromLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
