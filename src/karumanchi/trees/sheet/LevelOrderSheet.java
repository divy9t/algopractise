package karumanchi.trees.sheet;

import karumanchi.trees.TreeNode;

import java.util.*;

public class LevelOrderSheet {
    public static void main(String[] args) {
        LevelOrderSheet levelOrderSheet = new LevelOrderSheet();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        levelOrderSheet.levelOrder(root);
    }

    private ArrayList<Integer> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        queue.add(root);
        StringBuilder levelOrder = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                deque.add(poll);
                if (poll.right != null) queue.add(poll.right);
                if (poll.left != null) queue.add(poll.left);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int val = deque.pollLast().val;
            levelOrder.append(val);
            list.add(val);
        }
        System.out.println(levelOrder);
        return list;
    }
}
