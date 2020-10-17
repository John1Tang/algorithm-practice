package com.jt.algo.practice.leetcode;

/**
 * @description: 52. N-Queens II
 * @author: john
 * @created: 2020/10/17 19:24
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 *
 */
public class Lc0052 {
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve (int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, columns | position,
                        (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }
}
