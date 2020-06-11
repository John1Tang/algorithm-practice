package com.jt.algo.practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 739. Daily Temperatures
 * @author: john
 * @created: 2020/06/11 23:48
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 *
 */
public class Lc0739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < len; i++){
            int temperature = T[i];
            while(!stack.isEmpty() && temperature > T[stack.peek()]){
                int preIdx = stack.pop();
                ans[preIdx] = i - preIdx;
            }
            stack.push(i);
        }
        return ans;
    }
}
