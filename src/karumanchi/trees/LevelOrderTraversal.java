package karumanchi.trees;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        levelOrder(root);
        System.out.println(new LevelOrderTraversal().maxDepth(root));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        queue.add(root);



        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tempList.add(poll.val);

                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null)  queue.add(poll.right);

            }

            result.add(tempList);

        }

        return result;
    }

    public int maxDepth(TreeNode root) {

        return getMaxDepth(root, 0);


    }

    public int getMaxDepth(TreeNode root, Integer depth) {
        if (root == null)
            return depth;

        int left = getMaxDepth(root.left, depth + 1);
        int right = getMaxDepth(root.right, depth + 1);
        return Math.max(left, right);

    }


}
