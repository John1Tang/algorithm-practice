package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. Generate Parentheses
 * @author: john
 * @created: 2020/05/02 21:40
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class Lc0022_dp {
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();

        dp0.add("");
        dp.add(dp0);

        for(int i = 1; i <= n; i++){
            List<String> cur = new ArrayList<>();
            for(int j = 0; j < i; j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for(String s1 : str1){
                    for(String s2 : str2){
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
