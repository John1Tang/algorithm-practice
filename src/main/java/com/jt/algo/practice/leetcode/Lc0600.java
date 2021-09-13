package com.jt.algo.practice.leetcode;

/**
 * @description: 600. Non-negative Integers without Consecutive Ones
 * @author: john
 * @created: 2021/09/11 20:42
 *
 *
 * Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 * Example 2:
 *
 * Input: n = 1
 * Output: 2
 * Example 3:
 *
 * Input: n = 2
 * Output: 3
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 109
 *
 */
public class Lc0600 {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[1] = dp[0] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }
        return res;
    }
}
