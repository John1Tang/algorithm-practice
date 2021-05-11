package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 87. Scramble String
 * @author: john
 * @created: 2021/05/04 20:36
 *
 * We can scramble a string s to get a string t using the following algorithm:
 *
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 *
 *  
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Explanation: One possible scenario applied on s1 is:
 * "great" --> "gr/eat" // divide at random index.
 * "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
 * "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
 * "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
 * "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
 * The algorithm stops now and the result string is "rgeat" which is s2.
 * As there is one possible scenario that led s1 to be scrambled to s2, we return true.
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * Example 3:
 *
 * Input: s1 = "a", s2 = "a"
 * Output: true
 *  
 *
 * Constraints:
 *
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 and s2 consist of lower-case English letters.
 *  */
public class Lc0087 {
    // 记忆化搜索存储状态的数组
    // -1 表示 false，1 表示 true，0 表示未计算
    int[][][] memo;
    String s1, s2;


    public boolean isScramble (String s1, String s2) {
        int len = s1.length();
        this.memo = new int[len][len][len + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, len);
    }

    // 第一个字符串从 i1 开始，第二个字符串从 i2 开始，子串的长度为 length，是否和谐
    public boolean dfs(int i1, int i2, int len) {
        if (memo[i1][i2][len] != 0) {
            return memo[i1][i2][len] == 1;
        }

        // 判断两个子串是否相等
        if (s1.substring(i1, i1 + len).equals(s2.substring(i2, i2 + len))) {
            memo[i1][i2][len] = 1;
            return true;
        }

        // 判断是否存在字符 c 在两个子串中出现的次数不同
        if(!checkIfSimilar(i1, i2, len)) {
            memo[i1][i2][len] = -1;
            return false;
        }

        // 枚举分割位置
        for (int i = 1; i < len; ++i) {
            // the part that do not exchange
            if (dfs(i1, i2, 1) && dfs(i1 + i, i2 + i, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
            // when exchanging happens
            if (dfs(i1, i2 + len - i, i) && dfs(i1 + i, i2, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
        }

        memo[i1][i2][len] = -1;
        return false;

    }

    public boolean checkIfSimilar(int i1, int i2, int len) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = i1; i < i1 + len; ++i) {
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + len; ++i) {
            char c = s2.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
