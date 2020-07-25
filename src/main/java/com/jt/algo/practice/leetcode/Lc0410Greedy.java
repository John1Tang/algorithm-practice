package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 410. Split Array Largest Sum
 * @author: john
 * @created: 2020/07/25 23:30
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 *
 */
public class Lc0410Greedy {

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if(left < nums[i]){
                left = nums[i];
            }
        }
        while (left < right){
            int mid = (right - left) / 2 + left;
            if(check(nums, mid, m)){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m){
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++){
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}
