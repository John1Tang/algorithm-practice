package com.jt.algo.practice.leetcode;

/**
 * @description: 371. Sum of Two Integers
 * @author: john
 * @created: 2021/09/26 22:03
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *  
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *  
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 *
 *
 */
public class Lc0371 {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            System.out.println("carry: " + carry);
            a = a ^ b;
            System.out.println("a: " + a);
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        getSum(345, 34535);
    }
}
