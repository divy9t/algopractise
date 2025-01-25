package karumanchi.trees;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new LeastCommonAncestor().lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return null;

        if (root == left || root == right)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, left, right);
        TreeNode rightNode = lowestCommonAncestor(root.right, left, right);

        if (leftNode != null && rightNode != null) return root;
        if (leftNode != null) return leftNode;
        else return rightNode;

    }
}

