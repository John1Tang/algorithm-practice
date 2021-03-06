package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Lc0003 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), result = 0;
        if (len == 0) {
            return 0;
        }
        Map<Character, Integer> charIdxMap = new HashMap<>();
        for(int start = 0, end = 0; end < len; end++){
            char curChar = s.charAt(end);
            if(charIdxMap.containsKey(curChar)){
                start = Math.max(charIdxMap.get(curChar), start);
            }
            result = Math.max(result, end - start + 1);
            charIdxMap.put(curChar, end + 1);
        }
        return result;
    }
}
