package com.jt.algo.practice.leetcode;

/**
 * @description: 392. Is Subsequence
 * @author: john
 * @created: 2020/07/27 23:06
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *  
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 *
 *
 */
public class Lc0392 {

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for(int i = 0; i < 26; i++){
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--){
            for (int j = 0; j < 26; j++){
                if (t.charAt(i) == j + 'a'){
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++){
            if (f[add][s.charAt(i) - 'a'] == m){
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");
    }
}
