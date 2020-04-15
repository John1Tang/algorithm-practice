package com.jt.algo.practice;

/**
 * 29. Divide Two Integers
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */
public class Lc0029 {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = - divisor;
        }
        while(dividend <= divisor){
            int tmp_result = -1;
            int tmp_divisor = divisor;
            while(dividend <= (tmp_divisor << 1)){
                if(tmp_divisor <= (Integer.MIN_VALUE >> 1)){
                    break;
                }
                tmp_result = tmp_result << 1;
                tmp_divisor = tmp_divisor << 1;
            }
            dividend = dividend - tmp_divisor;
            result += tmp_result;
        }
        if(!sign){
            if(result <= Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
