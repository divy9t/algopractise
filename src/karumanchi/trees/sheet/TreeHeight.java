package karumanchi.trees.sheet;

import karumanchi.heap.final450.MergeBinaryMaxHeap;
import karumanchi.trees.TreeNode;

public class TreeHeight {
    int i=0;
    public static void main(String[] args) {
        TreeHeight treeHeight = new TreeHeight();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(treeHeight.height(root));
    }

    private int height(TreeNode root) {
        return getTreeHeight(root,i);


    }

    private int getTreeHeight(TreeNode root, int i) {
        if (root == null)
            return i;


        int l = getTreeHeight(root.left, i + 1);
        int r = getTreeHeight(root.right, i + 1);

        return Math.max(l,r);
    }
}
