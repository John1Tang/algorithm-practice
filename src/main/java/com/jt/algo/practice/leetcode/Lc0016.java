package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 16. 3Sum Closest
 * @author: john
 * @created: 2020/06/25 16:03
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *  
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 */
public class Lc0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10_000_000;

        for(int i = 0; i < n; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if(sum > target){
                    int k0 = k - 1;
                    while(j < k0 && nums[k0] == nums[k]){
                        --k0;
                    }
                    k = k0;
                }else{
                    int j0 = j + 1;
                    while(j0 < k && nums[j0] == nums[j]){
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

}
