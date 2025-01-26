package karumanchi.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerialiseDeserialiseTree {
    public static void main(String[] args) {
        SerialiseDeserialiseTree serialiseDeserialiseTree = new SerialiseDeserialiseTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);
        String serialisedTree = serialiseDeserialiseTree.serialize(root);
        System.out.println(serialisedTree);
        TreeNode dize = serialiseDeserialiseTree.deserialize(serialisedTree);
        System.out.println(dize);
        System.out.println(dize.equals(root));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder finalResult = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                finalResult.append(poll != null ? poll.val : null);
                finalResult.append(",");
                if (poll == null)
                    continue;
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }

        return finalResult.substring(0, finalResult.length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] data_array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(data_array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < data_array.length) {
            TreeNode poll = queue.poll();
            if (!Objects.equals(data_array[i], "null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(data_array[i]));
                poll.left = leftNode;
                queue.add(leftNode);

            }
            i++;
            if (!Objects.equals(data_array[i], "null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(data_array[i]));
                poll.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }

        return root;

    }

}
