package com.jt.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 84. Largest Rectangle in Histogram
 * @author: john
 * @created: 2020/05/31 13:21
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *  
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *  
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *  
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 *
 */
public class Lc0084 {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> monoStack = new Stack<>();
        for(int i = 0; i < n; ++i){
            while(!monoStack.isEmpty() && heights[monoStack.peek()] > heights[i]){
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; ++i){
            ans = Math.max(ans, (right[i] - left[i] -1 ) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,3,5,4,7,6,9});
    }
}
