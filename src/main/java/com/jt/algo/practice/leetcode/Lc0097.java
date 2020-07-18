package com.jt.algo.practice.leetcode;

/**
 * @description: 97. Interleaving String
 * @author: john
 * @created: 2020/07/18 23:09
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 *
 */
public class Lc0097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if(n + m != t){
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= m; ++j){
                int p = i + j - 1;
                if(i > 0){
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if(j > 0){
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[m];
    }
}
