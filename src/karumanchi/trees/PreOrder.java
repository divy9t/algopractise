package karumanchi.trees;

import java.util.ArrayList;
import java.util.List;

// left --> root --> right
public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new ArrayList<>();

        new PreOrder().preorderTraversal(root,result);
        System.out.println(result);

    }

    private List<Integer> preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return list;
        }

        preorderTraversal(root.left, list);
        list.add(root.val);
        preorderTraversal(root.right, list);
        return list;
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return list;
        }

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
        return list;
    }


}
