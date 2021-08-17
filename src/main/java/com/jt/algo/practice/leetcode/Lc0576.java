package com.jt.algo.practice.leetcode;

/**
 * @description: 576. Out of Boundary Paths
 * @author: john
 * @created: 2021/08/16 22:46
 *
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *  
 *
 * Constraints:
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 */
public class Lc0576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1_000_000_007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCnt = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int cnt = dp[j][k];
                    if (cnt > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 <n) {
                                dpNew[j1][k1] = (dpNew[j1][k1] + cnt) % MOD;
                            } else {
                                outCnt = (outCnt + cnt) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return outCnt;
    }
}
