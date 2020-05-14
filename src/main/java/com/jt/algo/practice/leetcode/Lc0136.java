package com.jt.algo.practice.leetcode;

/**
 * @description: 136. Single Number
 * @author: john
 * @created: 2020/05/14 21:39
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class Lc0136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num:nums){
            single ^= num;
        }
        return single;
    }
}
