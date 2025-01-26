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

    private int diameter(TreeNode root) {
        getDiameter(root );
        return maxDia;
    }

    private int getDiameter(TreeNode root) {
        if (root == null) {
            return 0; // Base case: height of a null node is 0
        }

        // Calculate the height of left and right subtrees
        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);

        // Update the maximum diameter
        maxDia = Math.max(maxDia, leftHeight + rightHeight);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
