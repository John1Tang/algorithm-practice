package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 46. Permutations
 * @author: john
 * @created: 2020/04/25 23:39
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Lc0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        List<Integer> output = new ArrayList<Integer>();
        for(int num : nums){
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n,
                           List<Integer> output,
                           List<List<Integer>> res,
                           int first){
        if(first == n){
            res.add(new ArrayList<Integer>(output));
        }

        for(int i = first; i < n; i++){
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
