package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import java.util.Objects;

@SuppressWarnings("unused")
public class StackImplementation {
    public static void main(String[] args) {
        Node head = Node.getSingleLinkedList();

        StackImplementation stack = new StackImplementation();
        head = stack.push(0, head);
        head = stack.push(-1, head);
        head = stack.pop(head);

        Node.printLinkedList(head);

        System.out.println();
        System.out.println(stack.peek(head));

    }

    public int size (Node head) {
        int size = 1;
        if (Objects.isNull(head))
            return size;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        return size;
    }
    public boolean isEmpty (Node head) {
        return Objects.isNull(head);
    }
    public Node push(int value, Node head) {
        Node node = Node.getNode(value);
        if (isEmpty(head))
            head = node;

        node.next = head;
        return node;
    }
    public Node pop(Node head) {
        return head.next;
    }
    public Integer peek(Node head) {
        return head.val;
    }
}
