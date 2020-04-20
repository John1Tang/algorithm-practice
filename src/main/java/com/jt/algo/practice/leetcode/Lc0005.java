package com.jt.algo.practice.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 */
public class Lc0005 {
    public String longestPalindrome(String s) {

        int sLen = s.length();
        if(s.length() <= 1){
            return s;
        }

        int maxPalindrome = 1;
        String maxPalindromeStr = s.substring(0, 1);
        boolean dp [][] = new boolean [sLen][sLen];

        for(int r = 1; r < sLen; r++){
            for(int l = 0; l < r; l++){
                if( s.charAt(l)  == s.charAt(r) && ( (r -l <=  2) || dp[ l + 1 ][r - 1])){
                    dp[l][r] = true;
                    if( r - l  + 1 > maxPalindrome){
                        maxPalindrome = r - l + 1;
                        maxPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return maxPalindromeStr;
    }
}
