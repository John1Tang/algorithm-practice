package com.jt.algo.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 151. Reverse Words in a String
 * @author: john
 * @created: 2020/05/02 22:35
 *
 * Given an input string, reverse the string word by word.
 *
 *  
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *  
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *  
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 */
public class Lc0151_deque {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' '){
            ++left;
        }
        while(left <= right && s.charAt(right) == ' '){
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while(left <= right){
            char c = s.charAt(left);
            if((word.length() != 0) && (c == ' ')){
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if(c != ' '){
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }
}
