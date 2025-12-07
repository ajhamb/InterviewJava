package interviewjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarrayProblemsTest {

    private SubarrayProblems sp;

    @BeforeEach
    public void setUp() {
        sp = new SubarrayProblems();
    }

    @Test
    public void testBasicCase() {
        // The longest subarray with at most two distinct integers is [1, 2, 1, 2]
        assertEquals(4, sp.maxSubarraywithTwoDistinctIntegers(new int[]{0, 1, 2, 1, 2, 3}));
    }

    @Test
    public void testAnotherBasicCase() {
        // The longest subarray is [1, 2, 1]
        assertEquals(3, sp.maxSubarraywithTwoDistinctIntegers(new int[]{1, 2, 1, 3, 4, 3, 5}));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, sp.maxSubarraywithTwoDistinctIntegers(new int[]{}));
    }

    @Test
    public void testNullArray() {
        assertEquals(0, sp.maxSubarraywithTwoDistinctIntegers(null));
    }

    @Test
    public void testAllSameElements() {
        // The subarray has only one distinct integer, which is valid.
        assertEquals(5, sp.maxSubarraywithTwoDistinctIntegers(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testOnlyTwoDistinctElements() {
        // The entire array is the longest subarray.
        assertEquals(6, sp.maxSubarraywithTwoDistinctIntegers(new int[]{1, 2, 1, 2, 1, 2}));
    }

    @Test
    public void testSingleElementArray() {
        assertEquals(1, sp.maxSubarraywithTwoDistinctIntegers(new int[]{5}));
    }

    @Test
    public void testComplexCase() {
        // The longest subarray is [1, 2, 1, 2, 1]
        assertEquals(5, sp.maxSubarraywithTwoDistinctIntegers(new int[]{5, 1, 2, 1, 2, 1, 5, 5, 5}));
    }
}