package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import java.util.HashMap;

public class NthNodeFromLast {
    static HashMap<Integer, Node> nodeMap ;
    static int listLength ;

    public static void main(String[] args) {
        Node head = Node.getSingleLinkedList();
        nodeMap = getNodeHashMapFromHead(head);
        Node.printLinkedList(head);
        System.out.println(getNthNodeValue(2).val);
        System.out.println(getNthNodeValue(3).val);
        System.out.println(getNthNodeValue(1).val);

        System.out.println(getNthNodeValueFromBack(1).val);
        System.out.println(getNthNodeValueFromBack(3).val);

        //try to solve it in one scan
        getNthNodeValueInOneScan(3, head);

    }

    private static void getNthNodeValueInOneScan(int i, Node head) {
        Node p = head;
        Node q = head.next;

        while (q != null) {
            q = q.next;
            if (i <= 0)
                p = p.next;
            else
                i--;
        }
        System.out.println("--------");
        System.out.println(p.val);


    }

    private static HashMap<Integer, Node> getNodeHashMapFromHead(Node head) {
        int i = 0;
        HashMap<Integer, Node> nodeMap = new HashMap<>();

        Node current  = head;
        while (current != null) {
            nodeMap.put(i, current);
            i++;
            current = current.next;
        }
        listLength = i - 1;
        return nodeMap;
    }

    static Node getNthNodeValue(int nodePosition) {
        return nodeMap.get(nodePosition);
    }

    static Node getNthNodeValueFromBack(int nodePosition) {
        int position  = listLength - nodePosition + 1;
        return nodeMap.get(position);
    }

}
