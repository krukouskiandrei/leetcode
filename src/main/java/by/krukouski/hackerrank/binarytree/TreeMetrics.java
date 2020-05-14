package by.krukouski.hackerrank.binarytree;

import by.krukouski.leetcode.binarytree.TreeNode;

public class TreeMetrics {

    public static int height(final TreeNode root) {
        return getMaxNodeHeight(root);
    }

    private static int getMaxNodeHeight(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }

        int leftNodeHeight = node.getLeft() != null ? getMaxNodeHeight(node.getLeft()) : 0;
        int rightNodeHeight = node.getRight() != null ? getMaxNodeHeight(node.getRight()) : 0;

        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }
}
