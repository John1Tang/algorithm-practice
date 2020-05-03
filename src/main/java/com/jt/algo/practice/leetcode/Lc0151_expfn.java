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
public class Lc0151_expfn {
    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' '){
            ++left;
        }

        while (left <= right && s.charAt(right) == ' '){
            --right;
        }

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' '){
                ++end;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        reverse(sb, 0, sb.length() - 1);

        reverseEachWord(sb);

        return sb.toString();
    }
}
