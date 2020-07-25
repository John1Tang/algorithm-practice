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
public class Lc0410Dp {

    /**
     * 时间复杂度：O(n^2 \times m)O(n
     * 2
     *  ×m)，其中 nn 是数组的长度，mm 是分成的非空的连续子数组的个数。总状态数为 O(n \times m)O(n×m)，状态转移时间复杂度 O(n)O(n)，所以总时间复杂度为 O(n^2 \times m)O(n
     * 2
     *  ×m)。
     *
     * 空间复杂度：O(n \times m)O(n×m)，为动态规划数组的开销
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }

        int[] sub = new int[n + 1];
        for(int i = 0; i < n; i++){
            sub[i + 1] = sub[i] + nums[i];
        }

        f[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= Math.min(i, m); j++){
                for(int k = 0; k < i; k++){
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
