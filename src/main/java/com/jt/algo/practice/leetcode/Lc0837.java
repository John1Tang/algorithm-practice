package com.jt.algo.practice.leetcode;

/**
 * @description: 837. New 21 Game
 * @author: john
 * @created: 2020/06/03 22:13
 *
 * Alice plays the following game, loosely based on the card game "21".
 *
 * Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
 *
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 *
 * Example 1:
 *
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * Example 2:
 *
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * Example 3:
 *
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * Note:
 *
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 * The judging time limit has been reduced for this question.
 *
 */
public class Lc0837 {
    public double new21Game(int N, int K, int W) {
        if(K == 0){
            return 1.0;
        }
        double[] dp = new double[K + W];
        for(int i = K; i <= N && i < K + W; i++){
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for(int i = K - 2; i >= 0; i--){
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
