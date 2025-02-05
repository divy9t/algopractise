package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        zigZagTraversal(root);


    }

    public static void zigZagTraversal (TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < size; i ++ ) {
                TreeNode poll = queue.poll();
                temp.add(poll);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }

            while (!temp.isEmpty()) {
                if (level % 2 == 0) {
                    System.out.println(temp.pollLast().val);
                } else {
                    System.out.println(temp.pollFirst().val);
                }
            }
            level++;

        }
    }
}
