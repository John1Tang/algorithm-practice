package com.jt.algo.practice.leetcode;

/**
 * @description: 474. Ones and Zeroes
 * @author: john
 * @created: 2021/06/14 22:44
 *
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 *  
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *  
 *
 * Constraints:
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 *
 */
public class Lc0474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            int[] zeroOnes = getZerosOnes(strs[i]);
            int zeros = zeroOnes[0], ones = zeroOnes[1];
            System.out.println("zeros: " + zeros + "ones: " + ones);
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    System.out.println("dp["+j+"]["+k+"]: " + dp[j][k] + ", dp["+(j - zeros)+"]["+(k - ones)+"]: " + dp[j - zeros][k - ones]);
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public static int[] getZerosOnes(String str) {
        int[] zeroOnes = new int[2];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            zeroOnes[str.charAt(i) - '0']++;
        }
        return zeroOnes;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
    }
}
