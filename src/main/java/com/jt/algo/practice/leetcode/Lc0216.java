package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 216. Combination Sum III
 * @author: john
 * @created: 2020/09/14 08:29
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 *
 */
public class Lc0216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        //终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - i);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}
