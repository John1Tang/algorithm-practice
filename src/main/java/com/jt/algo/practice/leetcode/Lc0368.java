package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 368. Largest Divisible Subset
 * @author: john
 * @created: 2021/04/23 22:35
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 *
 *
 */
public class Lc0368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // step 1 find the greatest integer from the most subset
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // step 2 deduce the most subset
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
