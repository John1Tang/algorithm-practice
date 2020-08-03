package com.jt.algo.practice.crackinterview;

/**
 * @description: 面试题 08.03. Magic Index LCCI
 * @author: john
 * @created: 2020/08/03 00:32
 *
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. Given a sorted array of integers, write a method to find a magic index, if one exists, in array A. If not, return -1. If there are more than one magic index, return the smallest one.
 *
 * Example1:
 *
 *  Input: nums = [0, 2, 3, 4, 5]
 *  Output: 0
 * Example2:
 *
 *  Input: nums = [1, 1, 1]
 *  Output: 1
 * Note:
 *
 * 1 <= nums.length <= 1000000
 * This problem is the follow-up of the original problem in the book, i.e. the values are not distinct.
 *
 *
 */
public class Cciv0803 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
