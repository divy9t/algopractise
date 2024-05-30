package karumanchi.trees;

public class RecursivePreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println("Root Element is: " + root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
