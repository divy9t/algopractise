package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

public class TreeDiameter {
    int maxDia = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        double diameter = new TreeDiameter().diameter(root);
        System.out.println(diameter);
    }

    private double diameter(TreeNode root) {
        getDiameter(root);
        return maxDia;
    }

    private int getDiameter(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);

        maxDia = Math.max(maxDia, left + right);

        return Math.max(left, right) + 1;
    }


}
