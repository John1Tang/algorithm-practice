package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 525. Contiguous Array
 * @author: john
 * @created: 2021/06/08 21:16
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 *
 */
public class Lc0525 {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
                System.out.println("counter: " + counter + ", prevIndex: " + prevIndex + ", i: " + i + ", maxLength: " + maxLength);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        findMaxLength(new int[]{1, 0, 0, 1, 1, 1, 0, 1, 0});
    }
}
