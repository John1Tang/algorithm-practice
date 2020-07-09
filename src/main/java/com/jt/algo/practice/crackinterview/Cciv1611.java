package com.jt.algo.practice.crackinterview;

/**
 * @description: 面试题 16.11. Diving Board LCCI
 * @author: john
 * @created: 2020/07/09 22:52
 *
 * You are building a diving board by placing a bunch of planks of wood end-to-end. There are two types of planks, one of length shorter and one of length longer. You must use exactly K planks of wood. Write a method to generate all possible lengths for the diving board.
 *
 * return all lengths in non-decreasing order.
 *
 * Example:
 *
 * Input:
 * shorter = 1
 * longer = 2
 * k = 3
 * Output:  {3,4,5,6}
 * Note:
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 */
public class Cciv1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }
}
