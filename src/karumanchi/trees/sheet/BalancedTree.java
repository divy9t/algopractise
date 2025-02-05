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

        getTreeHeight(root);
    }

    private static int getTreeHeight(TreeNode root) {
        if


    }

}
