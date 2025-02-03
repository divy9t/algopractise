package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        new TopView().topView(root);

    }

    private void topView(TreeNode root) {
        if (root == null)
            return;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr = root;
        while (curr.left != null) {
            stack.push(curr.left);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.poll().val + "-");
        }

        curr = root;
        while (curr.right != null) {
            stack.push(curr.right);
            curr = curr.right;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollLast().val + "-");
        }



    }
}
