package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 350. Intersection of Two Arrays II
 * @author: john
 * @created: 2020/07/13 23:04
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 *
 */
public class Lc0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int idx1 = 0, idx2 = 0, idx = 0;
        while(idx1 < length1 && idx2 < length2){
            if(nums1[idx1] < nums2[idx2]){
                idx1++;
            }else if(nums1[idx1] > nums2[idx2]){
                idx2++;
            }else{
                intersection[idx] = nums1[idx1];
                idx1++;
                idx2++;
                idx++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, idx);
    }
}
