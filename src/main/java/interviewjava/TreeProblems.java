package interviewjava;

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
}