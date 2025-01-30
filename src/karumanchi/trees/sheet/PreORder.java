package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.Stack;

public class PreORder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        new PreORder().preOrderViaRecursion(root);
        new PreORder().preOrderViaIteration(root);
    }

    private void preOrderViaRecursion(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrderViaRecursion(root.left);
        preOrderViaRecursion(root.right);
    }

    private void preOrderViaIteration(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();

       stack.push(root) ;

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);

            if (pop.right != null)
                stack.push(pop.right);

            if (pop.left != null)
                stack.push(pop.left);
        }


    }
}
