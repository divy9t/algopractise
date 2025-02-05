package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

public class BalancedTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.horizontalDistance = 0;
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);

        isTreeBalanced(root);
    }

    private static boolean isTreeBalanced(TreeNode root) {
        return getTreeHeight(root) != -1;
    }

    private static int getTreeHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getTreeHeight(root.left);
        if (left == -1) return -1;
        int right = getTreeHeight(root.right);
        if (right == -1) return -1;


        if ((Math.max(left, right) - Math.min(left, right)) > 1) return -1;

        return Math.max(left, right) + 1;

    }

}
