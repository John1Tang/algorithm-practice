package com.jt.algo.practice.leetcode;

/**
 * @description: 233. Number of Digit One
 * @author: john
 * @created: 2021/08/13 22:02
 *
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 6
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 0 <= n <= 109
 *
 *
 */
public class Lc0233 {
    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
