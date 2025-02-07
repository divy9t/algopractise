package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.*;

public class DiagonalTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        diagonalTraversal(root);
    }

    private static void diagonalTraversal(TreeNode root) {
        if (root == null)
            return;


        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        root.horizontalDistance = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int horizontalDistance = current.horizontalDistance;
            List<Integer> value = map.getOrDefault(horizontalDistance, new ArrayList<>());
            value.add(current.val);
            map.put(horizontalDistance, value);

            if (current.left != null) {
                current.left.horizontalDistance = horizontalDistance - 1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.horizontalDistance = horizontalDistance;
                queue.add(current.right);
            }

        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
