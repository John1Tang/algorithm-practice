package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 132. Palindrome Partitioning II
 * @author: john
 * @created: 2021/04/19 08:07
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 *
 *
 */
public class Lc0132 {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
                System.out.println("i: " + i + ", j: " + j + ", g[i][j]:" + g[i][j]);
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                        System.out.println("i: " + i + ", j: " + j + ", f[i]:" + f[i]);
                    }
                }
            }
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        int ret = minCut("aab");
        System.out.println(ret);
    }
}
