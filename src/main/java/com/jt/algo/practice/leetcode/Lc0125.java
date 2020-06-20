package com.jt.algo.practice.leetcode;

/**
 * @description: 125. Valid Palindrome
 * @author: john
 * @created: 2020/06/20 21:45
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 */
public class Lc0125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                ++left;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                --right;
            }
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
