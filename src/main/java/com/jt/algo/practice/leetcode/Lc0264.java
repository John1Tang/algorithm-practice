package com.jt.algo.practice.leetcode;

/**
 * @description: 264. Ugly Number II
 * @author: john
 * @created: 2021/04/11 23:03
 *
 *
 * Given an integer n, return the nth ugly number.
 *
 * Ugly number is a positive number whose prime factors only include 2, 3, and/or 5.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 is typically treated as an ugly number.
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 *
 *
 */
public class Lc0264 {
    public int nthUglyNumber(int n) {
        int[] dp =  new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
