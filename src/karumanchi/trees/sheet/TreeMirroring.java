package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

public class TreeMirroring {
    public static void main(String[] args) {
        TreeMirroring treeMirroring = new TreeMirroring();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        TreeNode mirror = treeMirroring.mirror(root);
        System.out.println(mirror);
    }

    private TreeNode mirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);

        return root;
    }
}
