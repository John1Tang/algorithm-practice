package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 229. Majority Element II
 * @author: john
 * @created: 2021/10/26 08:16
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 *
 */
public class Lc0229 {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                // current element is the first
                vote1++;
            } else if (vote2 > 0 && num == element2) {
                vote2++;
            } else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }

        // check if ocurrence times match the condition
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }
}
