package karumanchi.heap.final450;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        Node head3 = new Node(0);
        head3.next = new Node(9);
        head3.next.next = new Node(10);

        Node[] arr = {head1, head2, head3};

        Node result = mergeKSortedLinkedList(arr);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    private static Node mergeKSortedLinkedList(Node[] arr) {
        Node head = new Node(0);
        Node temp = head;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.data)
        );

        priorityQueue.addAll(Arrays.asList(arr));
        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty()) {
            Node poll = priorityQueue.poll();
            temp.next = poll;
            temp = temp.next;
            if (poll.next != null)
                priorityQueue.add(poll.next);
        }



        while (head.next != null) {
            System.out.println(head.data);
            head = head.next;
        }

        return null;
    }


    static class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
}
