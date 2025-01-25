package karumanchi.trees;

import java.util.Queue;

public class PopulateNextRightPointer {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        new PopulateNextRightPointer().connect(root);
        System.out.println(root);

    }

    private void connect(TreeNode root) {
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode prevNode = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                if (prevNode != null) {
                    prevNode.next = poll;
                }
                prevNode = poll;
            }
        }
    }
}