package com.jt.algo.practice.leetcode;

/**
 * @description: 152. Maximum Product Subarray
 * @author: john
 * @created: 2020/05/18 23:38
 *
 *Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class Lc0152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];

        int curMax;
        int curMin;

        int res = nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] >= 0){
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            }else{
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);

            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
