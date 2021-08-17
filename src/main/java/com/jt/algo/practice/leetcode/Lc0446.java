package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 446. Arithmetic Slices II - Subsequence
 * @author: john
 * @created: 2021/08/12 23:21
 *
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The answer is guaranteed to fit in 32-bit integer.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * Example 2:
 *
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 *  
 *
 * Constraints:
 *
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 *
 *
 */
public class Lc0446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        int ans = 0;

        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[k] ~ nums[i] - nums[j] = nums[j] - nums[k]
                // =====>  nums[k] = 2 * nums[j] - nums[i]
                long numsK = 2L * nums[j] - nums[i];
                if (numsK > Integer.MAX_VALUE || numsK < Integer.MIN_VALUE) {
                    continue;
                }
                // k fits in triple
                if (map.containsKey((int)numsK)) {
                    List<Integer> list = map.get((int) numsK);
                    for (Integer k : list) {
                        if (k < j) {
                            dp[j][i] += dp[k][j] + 1;
                        }
                    }
                }
                ans += dp[j][i];
            }
        }
        return ans;
    }
}
