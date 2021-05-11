package com.jt.algo.practice.leetcode;

/**
 * @description: 633. Sum of Square Numbers
 * @author: john
 * @created: 2021/05/04 20:39
 *
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 *
 *  
 *
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 * Example 3:
 *
 * Input: c = 4
 * Output: true
 * Example 4:
 *
 * Input: c = 2
 * Output: true
 * Example 5:
 *
 * Input: c = 1
 * Output: true
 *  
 *
 * Constraints:
 *
 * 0 <= c <= 231 - 1
 *
 */
public class Lc0633 {
    public boolean judgeSquareSum(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }

            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }

        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }
}
