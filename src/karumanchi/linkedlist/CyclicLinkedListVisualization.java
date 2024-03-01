package karumanchi.linkedlist;

public class CyclicLinkedListVisualization {
    public static void printCyclicLinkedList(Node head) {
        if (head == null) {
            System.out.println("Empty linked list.");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Detect the cycle using Floyd's Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If there's a cycle, break
            if (slow == fast)
                break;
        }

        // If there's no cycle, just print the linked list
        if (fast == null || fast.next == null) {
            Node current = head;
            do {
                System.out.print(current.val + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(Back to the beginning)");
            return;
        }

        // If there's a cycle, print until the meeting point
        Node current = head;
        while (current != fast) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        // Print the rest of the cycle
        System.out.print(current.val + " -> ... -> ");
        current = current.next;
        while (current != fast) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(current.val + " (Back to the cycle)");
    }

    public static void main(String[] args) {
        // Example: Creating a cyclic linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 2 (cyclic)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Creating the cycle
        head.next.next.next.next.next = head.next;

        // Visualize the cyclic linked list
        printCyclicLinkedList(head);
    }
}
