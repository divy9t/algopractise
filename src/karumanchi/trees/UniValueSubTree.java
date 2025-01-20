package karumanchi.trees;

public class UniValueSubTree {
    int count = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);


        System.out.println(new UniValueSubTree().countUnivalSubtrees(root));
    }

    public int countUnivalSubtrees(TreeNode root) {
        countTree(root);
        return count;
    }

    public boolean countTree(TreeNode root) {
       if (root == null)
           return true;
       boolean isUniTreeLeft = countTree(root.left);
       boolean isUniTreeRight = countTree(root.right);

       if (!isUniTreeLeft || !isUniTreeRight)
           return false;
       if (root.left != null && root.val != root.left.val)
           return false;
        if (root.right != null && root.val != root.right.val)
            return false;

        count++;
       return true;
    }
}
