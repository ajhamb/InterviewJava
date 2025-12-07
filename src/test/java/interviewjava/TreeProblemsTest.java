package interviewjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeProblemsTest {

    @Test
    void testFindTilt_emptyTree() {
        TreeProblems treeProblems = new TreeProblems();
        assertEquals(0, treeProblems.findTilt(null));
    }

    @Test
    void testFindTilt_singleNode() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(1);
        assertEquals(0, treeProblems.findTilt(root));
    }

    @Test
    void testFindTilt_simpleTree() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // Tilt of node 2 is 0
        // Tilt of node 3 is 0
        // Tilt of node 1 is abs(2 - 3) = 1
        // Total tilt = 0 + 0 + 1 = 1
        assertEquals(1, treeProblems.findTilt(root));
    }

    @Test
    void testFindTilt_complexTree() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Tilt of node 3 is 0
        // Tilt of node 5 is 0
        // Tilt of node 7 is 0
        // Tilt of node 2 is abs(3-5) = 2
        // Tilt of node 9 is abs(0-7) = 7
        // Sum of left subtree of root(4) = 3 + 5 + 2 = 10
        // Sum of right subtree of root(4) = 7 + 9 = 16
        // Tilt of node 4 is abs(10-16) = 6
        // Total tilt = 0 + 0 + 0 + 2 + 7 + 6 = 15
        assertEquals(15, treeProblems.findTilt(root));
    }

    @Test
    void testFindTilt_anotherComplexTree() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(7);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(3);

        // Tilt of node 3 (left) = 0
        // Tilt of node 3 (right) = 0
        // Tilt of node 2 (left.left) = abs(3-3) = 0
        // Tilt of node 2 (left.right) = 0
        // Tilt of node 2 (right.left) = 0
        // Tilt of node 2 (right.right) = 0
        // Sum of subtree at 2 (left.left) = 3+3+2=8
        // Tilt of node 7 = abs(8-2) = 6
        // Tilt of node 14 = abs(2-2) = 0
        // Sum of subtree at 7 = 8+2+7=17
        // Sum of subtree at 14 = 2+2+14=18
        // Tilt of node 21 = abs(17-18) = 1
        // Total tilt = 0+0+0+0+0+0+6+0+1 = 7. My manual calculation is wrong.
        // Let's re-calculate:
        // Tilt of node 3 (left): 0
        // Tilt of node 3 (right): 0
        // Sum of subtree at 3 (left): 3
        // Sum of subtree at 3 (right): 3
        // Tilt of node 2 (left.left): abs(3-3)=0
        // Sum of subtree at 2 (left.left): 3+3+2=8
        // Tilt of node 2 (left.right): 0
        // Sum of subtree at 2 (left.right): 2
        // Tilt of node 7: abs(8-2) = 6
        // Sum of subtree at 7: 8+2+7=17
        // Tilt of node 2 (right.left): 0
        // Sum of subtree at 2 (right.left): 2
        // Tilt of node 2 (right.right): 0
        // Sum of subtree at 2 (right.right): 2
        // Tilt of node 14: abs(2-2)=0
        // Sum of subtree at 14: 2+2+14=18
        // Tilt of node 21: abs(17-18)=1
        // Total Tilt = 0+0+0+0+6+0+0+1 = 7. Still 7.
        //
        // Let's dry run the code's logic.
        // computeTilt(3-left): returns 3. tiltSum = [0]
        // computeTilt(3-right): returns 3. tiltSum = [0]
        // computeTilt(2-left.left): leftSum=3, rightSum=3, tilt=0. tiltSum=[0]. returns 3+3+2=8
        // computeTilt(2-left.right): returns 2. tiltSum=[0]
        // computeTilt(7): leftSum=8, rightSum=2, tilt=6. tiltSum=[6]. returns 8+2+7=17
        // computeTilt(2-right.left): returns 2. tiltSum=[6]
        // computeTilt(2-right.right): returns 2. tiltSum=[6]
        // computeTilt(14): leftSum=2, rightSum=2, tilt=0, tiltSum=[6]. returns 2+2+14=18
        // computeTilt(21): leftSum=17, rightSum=18, tilt=1, tiltSum=[7]. returns 17+18+21=56
        // final tiltSum is 7.
        assertEquals(7, treeProblems.findTilt(root));
    }

    @Test
    void testFindTilt_leftSkewedTree() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        // Tilt of 3 is 0
        // Sum of subtree at 3 is 3
        // Tilt of 2 is abs(3-0) = 3
        // Sum of subtree at 2 is 3+2=5
        // Tilt of 1 is abs(5-0) = 5
        // Total tilt = 0 + 3 + 5 = 8
        assertEquals(8, treeProblems.findTilt(root));
    }

    @Test
    void testFindTilt_rightSkewedTree() {
        TreeProblems treeProblems = new TreeProblems();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        // Tilt of 3 is 0
        // Sum of subtree at 3 is 3
        // Tilt of 2 is abs(0-3) = 3
        // Sum of subtree at 2 is 3+2=5
        // Tilt of 1 is abs(0-5) = 5
        // Total tilt = 0 + 3 + 5 = 8
        assertEquals(8, treeProblems.findTilt(root));
    }
}
