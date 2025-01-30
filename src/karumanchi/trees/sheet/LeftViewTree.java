package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
    public static void main(String[] args) {
        LeftViewTree leftViewTree = new LeftViewTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        leftViewTree.leftView(root);
        System.out.println();
        leftViewTree.rightView(root);
    }

    private void leftView(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        leftView(root.left);

    }

    private void rightView(TreeNode root) {
       if (root == null) {
           return;
       }
        Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode poll = queue.poll();
               if (i == size - 1) {
                   System.out.print(poll.val + " ");
               }
               if (poll.left != null) queue.add(poll.left);
               if (poll.right != null) queue.add(poll.right);
           }
       }

    }
}
