package com.jt.algo.practice.crackinterview;

/**
 * @description: 08.11. Coin LCCI
 * @author: john
 * @created: 2020/04/23 22:44
 *
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write code to calculate the number of ways of representing n cents. (The result may be large, so you should return it modulo 1000000007)
 *
 * Example1:
 *
 *  Input: n = 5
 *  Output: 2
 *  Explanation: There are two ways:
 * 5=5
 * 5=1+1+1+1+1
 * Example2:
 *
 *  Input: n = 10
 *  Output: 4
 *  Explanation: There are four ways:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * Notes:
 *
 * You can assume:
 *
 * 0 <= n <= 1000000
 *
 */
public class Cciv0811 {
    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin; i < n+1; i++){
                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
