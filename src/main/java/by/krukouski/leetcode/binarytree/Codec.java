package by.krukouski.leetcode.binarytree;

import java.util.*;

public class Codec {

    private static final String NODE_SPLITTER = ",";
    private static final String NULL_VALUE = "null";

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {
        //recurtion
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(final String data) {
        final List<String> nodes = splitStringOfNodes(data);
        if (nodes.isEmpty() || nodes.get(0).equals(NULL_VALUE)) {
            return null;
        }

        TreeNode root = null;
        boolean isLeftNode = true;
        Queue<TreeNode> pull = new LinkedList<>();

        for(String node : nodes) {
            if (root == null) {
                root = new TreeNode(Integer.parseInt(node));
                pull.add(root);
                continue;
            }

            TreeNode newNode = null;
            if (isLeftNode) {
                Optional<TreeNode> tmpNode = Optional.ofNullable(pull.peek());
                newNode = node.equals(NULL_VALUE) ? null : new TreeNode(Integer.parseInt(node));
                if (newNode != null) {
                    tmpNode.orElseThrow(IllegalArgumentException::new).setLeft(newNode);
                }
            } else {
                Optional<TreeNode> tmpNode = Optional.ofNullable(pull.poll());
                newNode = node.equals(NULL_VALUE) ? null : new TreeNode(Integer.parseInt(node));
                if (newNode != null) {
                    tmpNode.orElseThrow(IllegalArgumentException::new).setRight(newNode);
                }
            }

            pull.add(newNode);
            isLeftNode = !isLeftNode;
        }

        return root;
    }


    private List<String> splitStringOfNodes(final String nodes) {
        return Arrays.asList(nodes.substring(1, nodes.length()-1).split(NODE_SPLITTER));
    }

}
