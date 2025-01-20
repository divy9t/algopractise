package karumanchi.trees;

public class HasSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(new HasSum().hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return hasSum(root, targetSum);


    }

    private boolean hasSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;


        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        boolean leftValidSum = hasSum(root.left, targetSum - root.val);
        if (leftValidSum)
            return true;
        return hasSum(root.right, targetSum - root.val);

    }
}

