package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 18. 4Sum
 * @author: john
 * @created: 2020/10/07 23:39
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Notice that the solution set must not contain duplicate quadruplets.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * <p>
 * Input: nums = [], target = 0
 * Output: []
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Lc0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;

        for (int k = 0; k < length - 3; k++) {

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }

            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }

            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int j = i + 1;
                int h = length - 1;

                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    break;
                }
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }

                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
