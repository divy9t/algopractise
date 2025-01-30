package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        new PostOrder().postOrderViaRecursion(root);
        new PostOrder().postOrderViaIteration(root);
    }

    private void postOrderViaRecursion(TreeNode root) {
        if (root == null)
            return;

        postOrderViaRecursion(root.left);
        postOrderViaRecursion(root.right);
        System.out.print(root.val + " ");

    }

    private void postOrderViaIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<TreeNode> out = new Stack<>();

        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            out.push(pop);

            if (pop.left != null)
                stack.push(pop.left);

            if (pop.right != null)
                stack.push(pop.right);
        }

        while (!out.isEmpty())
            System.out.print(out.pop().val + " ");
    }
}
