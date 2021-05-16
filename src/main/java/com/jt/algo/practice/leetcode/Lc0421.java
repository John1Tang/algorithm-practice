package com.jt.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 421. Maximum XOR of Two Numbers in an Array
 * @author: john
 * @created: 2021/05/16 22:18
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
 *
 * Follow up: Could you do this in O(n) runtime?
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [2,4]
 * Output: 6
 * Example 4:
 *
 * Input: nums = [8,10,2]
 * Output: 10
 * Example 5:
 *
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 *
 *
 */
public class Lc0421 {

    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }

            int xNext = x * 2 + 1;
            boolean found = false;

            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }


}
