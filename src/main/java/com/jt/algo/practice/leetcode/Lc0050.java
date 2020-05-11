package com.jt.algo.practice.leetcode;

/**
 * @description: 50. Pow(x, n)
 * @author: john
 * @created: 2020/05/11 23:20
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 */
public class Lc0050 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N){
        double ans = 1.0;
        double xContribute = x;

        while(N > 0){
            if(N % 2 == 1){
                ans *= xContribute;
            }
            xContribute *= xContribute;
            N /= 2;
        }
        return ans;
    }
}
