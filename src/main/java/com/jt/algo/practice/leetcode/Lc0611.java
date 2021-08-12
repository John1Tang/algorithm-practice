package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 611. Valid Triangle Number
 * @author: john
 * @created: 2021/08/05 21:28
 *
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 *
 */
public class Lc0611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}
