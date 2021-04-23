package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 131. Palindrome Partitioning
 * @author: john
 * @created: 2021/04/19 06:37
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 *
 */
public class Lc0131 {
    int[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition (String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs (String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public int isPalindrome (String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
