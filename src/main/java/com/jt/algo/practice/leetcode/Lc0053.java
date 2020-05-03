package com.jt.algo.practice.leetcode;

/**
 * @description: 53. Maximum Subarray
 * @author: john
 * @created: 2020/05/03 22:43
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 */
public class Lc0053 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;

        for(int num : nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
