package com.jt.algo.practice.leetcode;

/**
 * @description: 526. Beautiful Arrangement
 * @author: john
 * @created: 2021/08/22 22:50
 *
 *
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 *     - perm[1] = 1 is divisible by i = 1
 *     - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 *     - perm[1] = 2 is divisible by i = 1
 *     - i = 2 is divisible by perm[2] = 1
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 15
 *
 *
 */
public class Lc0526 {
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0
                        && ((num % (i + 1)) == 0
                        || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
