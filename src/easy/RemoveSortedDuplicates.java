package easy;

import java.util.List;
import java.util.Objects;

public class RemoveSortedDuplicates {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        deleteDuplicates(listNode);

    }

    private static ListNode printLis(ListNode listNode) {
    ListNode currentNode = listNode;

    while (currentNode != null) {
        System.out.print(currentNode.val + " ");
        currentNode = currentNode.next;
    }

    System.out.println(); // Print a newline at the end for formatting
    return listNode;
}
    private static ListNode deleteDuplicates(ListNode head) {

        if (head.next == null)
            return head;
        if (head.next.val == head.val) {
            head.next = head.next.next;
            return deleteDuplicates(head);
        } else
            deleteDuplicates(head.next);
        return head;

    }

    public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
}
