package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.horizontalDistance = 0;
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        bottomView(root,0, 0);
        System.out.println(root);
    }

    public static void bottomView(TreeNode root, int multiplier, int previous) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> horizontalTreeMap = new HashMap<>();

        queue.add(root);
        horizontalTreeMap.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            Integer hd = horizontalTreeMap.get(current);

            treeMap.put(hd, current.val);

            if (current.left != null) {
                queue.add(current.left);
                horizontalTreeMap.put(current.left, hd  - 1);
            }

            if (current.right != null) {
                queue.add(current.right);
                horizontalTreeMap.put(current.right, hd + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }


    }
}
