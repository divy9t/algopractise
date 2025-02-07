package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.horizontalDistance = 0;
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        ArrayList<Integer> list = new ArrayList<>();
        fillLeftNodes(root,list);
        fillLeafNodes(root, list);
        fillRightNodes(root, list);
        System.out.println(list);

    }

    private static void fillLeftNodes(TreeNode root, ArrayList<Integer> list) {
        if (root == null || isLeafNode(root))
            return;

        list.add(root.val);
        if (root.left != null) fillLeftNodes(root.left, list);
        else if (root.right != null) fillLeftNodes(root.right, list);

    }

    private static void fillRightNodes(TreeNode root, ArrayList<Integer> list) {
        if (root == null || isLeafNode(root))
            return;

        if (root.right != null) fillLeftNodes(root.right, list);
        else if (root.left != null) fillLeftNodes(root.left, list);
        list.add(root.val);

    }

    private static void fillLeafNodes(TreeNode root, ArrayList<Integer> list) {
        if (root == null )
            return;

        if (isLeafNode(root)) list.add(root.val);
        fillLeafNodes(root.left, list);
        fillLeafNodes(root.right, list);

    }



    private static boolean isLeafNode (TreeNode node) {
        return node.right == null && node.left == null;
    }

}