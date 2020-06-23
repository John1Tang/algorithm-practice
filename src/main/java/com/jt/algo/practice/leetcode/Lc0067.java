package com.jt.algo.practice.leetcode;

/**
 * @description: 67. Add Binary
 * @author: john
 * @created: 2020/06/23 22:54
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *  
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 *
 *
 */
public class Lc0067 {
    public String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int temp = 0;
        int a1 ;
        int b1 ;
        while (index1 >= 0 || index2 >= 0){

            a1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;
            b1 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;

            builder.append(a1 ^ b1 ^ temp);

            temp = (a1 + b1 + temp) >> 1;
        }
        if(temp > 0){
            builder.append(temp);
        }
        return builder.reverse().toString();
    }
}
