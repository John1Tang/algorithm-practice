package com.jt.algo.practice.leetcode;

import java.util.HashMap;

/**
 * @description: 560. Subarray Sum Equals K
 * @author: john
 * @created: 2020/05/15 23:41
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *  
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 */
public class Lc0560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            if(mp.containsKey(pre - k)){
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
