package com.jt.algo.practice.leetcode;

/**
 * @description: 415. Add Strings
 * @author: john
 * @created: 2020/08/03 22:21
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 */
public class Lc0415 {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int i = m - 1, j = n - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            int tmp = 0;
            int first = i < 0 ? 0 : num1.charAt(i) - '0';
            int second = j < 0 ? 0 :num2.charAt(j) - '0';
            tmp = first + second + carry;
            carry = tmp / 10;
            int remain = tmp % 10;
            res.append(remain);
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
