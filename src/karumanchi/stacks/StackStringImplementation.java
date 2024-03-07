package karumanchi.stacks;

import karumanchi.linkedlist.Node;

import java.util.Objects;

@SuppressWarnings("unused")
public class StackStringImplementation {


    public int size (StringNode head) {
        int size = 1;
        if (Objects.isNull(head))
            return size;
        StringNode current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        return size;
    }
    public boolean isEmpty (StringNode head) {
        return Objects.isNull(head) || Objects.isNull(head.val);
    }
    public StringNode push(String value, StringNode head) {
        StringNode node = StringNode.getNode(value);
        if (isEmpty(head)) {
            head = node;
            return head;
        }

        node.next = head;
        return node;
    }
    public StringNode pop(StringNode head) {
        return head.next;
    }
    public String peek(StringNode head) {
        return head.val;
    }
    public StringNode push(char value, StringNode head) {
        return push(String.valueOf(value), head);
    }
}
