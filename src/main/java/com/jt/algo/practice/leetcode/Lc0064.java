package com.jt.algo.practice.leetcode;

/**
 * @description: 64. Minimum Path Sum
 * @author: john
 * @created: 2020/07/24 10:30
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 */
public class Lc0064 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < columns; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
