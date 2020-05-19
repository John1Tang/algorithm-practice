package com.jt.algo.practice.leetcode;

/**
 * @description: 680. Valid Palindrome II
 * @author: john
 * @created: 2020/05/19 23:39
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 */
public class Lc0680 {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while(low < high){
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if(c1 == c2){
                low++;
                high--;
            }else{
                boolean flag1 = true, flag2 = true;
                for(int i = low, j =high - 1; i < j; i++, j--){
                    char c3= s.charAt(i), c4 = s.charAt(j);
                    if(c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                for(int i = low + 1, j = high; i < j; i++, j--){
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if(c3 != c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
