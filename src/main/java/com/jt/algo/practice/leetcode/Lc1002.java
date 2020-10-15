package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 1002. Find Common Characters
 * @author: john
 * @created: 2020/10/15 09:19
 */
public class Lc1002 {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }
        int[] minCount = new int[26];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for (String s : A) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minCount[i] = Math.min(minCount[i], count[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minCount[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
