/**
 * Utilities and algorithm implementations for common interview-style subarray problems.
 *
 * <p>This package collects well-documented solutions and helper utilities that demonstrate
 * standard approaches to working with contiguous subarrays and related array-window problems.
 * Implementations focus on clarity and correctness suitable for study, interview preparation,
 * and small-scale educational use.</p>
 *
 * <p>Typical algorithms and problem patterns included:
 * <ul>
 *   <li>Kadane's algorithm for maximum subarray sum</li>
 *   <li>Sliding window techniques for fixed- or variable-length windows</li>
 *   <li>Prefix-sum and hashmap approaches for subarray sum equals K</li>
 *   <li>Two-pointer methods for constrained subarray problems</li>
 *   <li>Minimum-size subarray with sum >= S</li>
 *   <li>Longest subarray with given properties (sum, distinct elements, divisible by K, etc.)</li>
 * </ul>
 * </p>
 *
 * <p>Design and conventions:
 * <ul>
 *   <li>Methods prefer immutable inputs where practical; when arrays are mutated, behavior is documented per method.</li>
 *   <li>Indexing is zero-based throughout.</li>
 *   <li>Most algorithms return primitive results or small DTOs; utility classes are typically static.</li>
 *   <li>Time and space complexity for each algorithm are documented on the implementing class/method.</li>
 *   <li>Null and edge-case handling (empty arrays, single-element arrays) is documented per method.</li>
 * </ul>
 * </p>
 *
 * <p>Usage note:
 * See the specific class-level javadoc for examples and expected input preconditions. This
 * package is intended for educational and interview-practice code; adaptions may be necessary
 * for production use (additional validation, concurrency considerations, and input sanitization).</p>
 *
 * @author GitHub Copilot
 * @since 1.0
 */
package interviewjava;

import java.util.HashMap;

public class SubarrayProblems {

    public int maxSubarraywithTwoDistinctIntegers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        HashMap<Integer, Integer> state = new HashMap<>();
        

        for(right = 0; right < nums.length; right++)
        {
            int curr = nums[right];
            state.put(curr, state.getOrDefault(curr, 0) + 1);
            
            while(state.size()>2)
            {
                int leftNum = nums[left];
                state.put(leftNum, state.get(leftNum) - 1);
                if(state.get(leftNum) == 0)
                {
                    state.remove(leftNum);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        
        return max;

    }

}