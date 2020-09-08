package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 77. Combinations
 * @author: john
 * @created: 2020/09/08 22:12
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 *
 */
public class Lc0077 {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= k; ++i) {
            tmp.add(i);
        }
        tmp.add(n + 1);
        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<>(tmp.subList(0, k)));
            j = 0;
            while (j < k && tmp.get(j) + 1 == tmp.get(j + 1)) {
                tmp.set(j, j + 1);
                ++j;
            }
            tmp.set(j, tmp.get(j) + 1);
        }
        return ans;
    }
}
