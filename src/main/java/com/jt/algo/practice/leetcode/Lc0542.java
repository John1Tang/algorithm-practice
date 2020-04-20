package com.jt.algo.practice.leetcode;

/**
 * 542. 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *  
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *  
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 */
public class Lc0542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return null;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if(j - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for(int i = row - 1; i >= 0; i--){
            for(int j = col -1; j >= 0; j--){
                if(i + 1 < row){
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if(j + 1 < col){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
