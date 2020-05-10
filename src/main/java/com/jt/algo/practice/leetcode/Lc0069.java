package com.jt.algo.practice.leetcode;

/**
 * @description: 69. Sqrt(x)
 * @author: john
 * @created: 2020/05/09 19:42
 *
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 *
 */
public class Lc0069 {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        double C = x, x0 = x;
        while(true){
            double xi = 0.5 * (x0 + C / x0);
            if(Math.abs(x0 -xi) < 1e-7){
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
