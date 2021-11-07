package com.jt.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 869. Reordered Power of 2
 * @author: john
 * @created: 2021/11/07 20:31
 *
 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this so that the resulting number is a power of two.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 * Example 2:
 *
 * Input: n = 10
 * Output: false
 * Example 3:
 *
 * Input: n = 16
 * Output: true
 * Example 4:
 *
 * Input: n = 24
 * Output: false
 * Example 5:
 *
 * Input: n = 46
 * Output: true
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 109
 *
 */
public class Lc0869 {
    Set<String> powerOf2Digits = new HashSet<String>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    public String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }
}
