package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 15. 3Sum
 * @author: john
 * @created: 2020/06/12 22:32
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class Lc0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int first = 0; first < n; ++first){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for(int second = first + 1; second < n; ++second){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
