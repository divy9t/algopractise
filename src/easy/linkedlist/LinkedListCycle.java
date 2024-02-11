package easy.linkedlist;

import easy.object.ListNode;

import java.util.Objects;

public class LinkedListCycle {

    public static void main(String[] args) {
        System.out.println(
        hasCycle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))))
        );
    }

    public static Boolean hasCycle(ListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next))
            return false;

        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {
            if (Objects.isNull(p.next))
                return false;
            p = p.next;
            q = q.next.next;
        }
        return true;

    }

}
