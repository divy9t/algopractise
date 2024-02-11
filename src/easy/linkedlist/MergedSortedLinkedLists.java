package easy.linkedlist;

import lombok.Builder;

public class MergedSortedLinkedLists {

    public static void main(String[] args) {
       printList(mergeTwoLists1(
               new ListNode(1, new ListNode(2, new ListNode(4, null))),
               new ListNode(1, new ListNode(3, new ListNode(4, null)))
       ));
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        int p = list1.val;
        int q = list2.val;

        if (p <= q) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
