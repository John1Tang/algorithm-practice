package com.jt.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @description: 313. Super Ugly Number
 * @author: john
 * @created: 2021/08/10 22:53
 *
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
 * Example 2:
 *
 * Input: n = 1, primes = [2,3,5]
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * primes[i] is guaranteed to be a prime number.
 * All the values of primes are unique and sorted in ascending order.
 *
 *
 */
public class Lc0313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minnum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minnum = Math.min(minnum, nums[j]);
            }
            dp[i] = minnum;
            for (int j = 0; j < m; j++) {
                if (minnum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
