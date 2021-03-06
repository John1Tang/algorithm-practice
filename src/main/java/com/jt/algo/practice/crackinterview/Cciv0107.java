package com.jt.algo.practice.crackinterview;

/**
 * @description: 08.11. Coin LCCI
 * @author: john
 * @created: 2020/04/23 22:44
 *
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 *  
 *
 * Example 1:
 *
 * Given matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * Rotate the matrix in place. It becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * Rotate the matrix in place. It becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 *
 */
public class Cciv0107 {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0; i < n / 2; ++i){
            for(int j = 0; j < n; ++j){
                swap(matrix, i, j, n - i - 1, j);
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                swap(matrix, i, j, j, i);
            }
        }

    }
    public void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        matrix[row1][col1] = matrix[row1][col1] ^ matrix[row2][col2];
        matrix[row2][col2] = matrix[row2][col2] ^ matrix[row1][col1];
        matrix[row1][col1] = matrix[row1][col1] ^ matrix[row2][col2];
    }
}
