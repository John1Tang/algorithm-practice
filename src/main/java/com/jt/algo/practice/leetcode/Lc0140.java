package com.jt.algo.practice.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 140. Word Break II
 * @author: john
 * @created: 2020/11/03 22:01
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class Lc0140 {
    List<String> res = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, 0, s.length(), new HashSet<>(wordDict), new boolean[s.length()], new StringBuilder());
        return res;
    }

    public void dfs(String s, int start, int length, HashSet<String> wordDict, boolean[] cantBreak, StringBuilder sb) {
        int resCurLen = res.size();
        if (start == length) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            sb.append(" ");
        } else {
            if (!cantBreak[start]) {
                String subString;
                for (int end = start + 1; end <= length; ++end) {
                    subString = s.substring(start, end);
                    if (wordDict.contains(subString)) {
                        int curLen = sb.length();
                        int appendLen = subString.length() + 1;
                        sb.append(subString).append(" ");
                        dfs(s, end, length, wordDict, cantBreak, sb);
                        sb.delete(curLen, curLen + appendLen);
                    }
                }
            }
            cantBreak[start] = res.size() <= resCurLen;
        }
    }
}
