package interviewjava;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class TreeProblems {

    // Sum of Tilt at TreeNode
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] tiltSum = new int[1];
        computeTilt(root, tiltSum);
        return tiltSum[0];
    }

    private int computeTilt(TreeNode node, int[] tiltSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = computeTilt(node.left, tiltSum);
        int rightSum = computeTilt(node.right, tiltSum);

        int tilt = Math.abs(leftSum - rightSum);
        tiltSum[0] += tilt;

        return leftSum + rightSum + node.val;
    }

    public int findLowestComonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }

        if(root.val == p || root.val == q) {
            return root.val;
        }

        int left = findLowestComonAncestor(root.left, p, q);
        int right = findLowestComonAncestor(root.right, p, q);

        if (left != -1 && right != -1) {
            return root.val;
        }

        return left != -1 ? left : right;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] diameter = new int[1];
        computeHeight(root, diameter);
        return diameter[0];
    }
    private int computeHeight(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = computeHeight(node.left, diameter);
        int rightHeight = computeHeight(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    
}