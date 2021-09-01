package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 1743. Restore the Array From Adjacent Pairs
 * @author: john
 * @created: 2021/08/30 11:41
 *
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *  
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 *  
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 *
 *
 */
public class Lc1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());

            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }
}
