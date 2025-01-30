package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InOrder {
    public static void main(String[] args) {
        InOrder inOrderViaRecursion = new InOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        inOrderViaRecursion.inOrderViaRecursion(root);
        System.out.println();
        inOrderViaRecursion.inOrderViaIteration(root);
    }

    private void inOrderViaRecursion(TreeNode root) {
        if (root == null)
            return;

        inOrderViaRecursion(root.left);
        System.out.print(root.val);
        inOrderViaRecursion(root.right);


    }

    private void inOrderViaIteration(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> queue = new Stack<>();
        TreeNode curr = root;

        while (!queue.isEmpty() || curr != null) {
            if (curr != null) {
                queue.add(curr);
                curr = curr.left;
            } else {
                TreeNode poll = queue.pop();
                System.out.print(poll.val);
                curr = poll.right;

            }
        }

    }
}
