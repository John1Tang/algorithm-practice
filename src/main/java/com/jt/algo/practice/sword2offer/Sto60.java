package com.jt.algo.practice.sword2offer;

/**
 * @description:
 * @author: john
 * @created: 2020/04/20 21:03
 *
 *
 * 面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 */
public class Sto60 {
    public double[] twoSum(int n) {
        int [][]dp = new int[n+1][6*n+1];

        for (int s = 1; s <= 6; s++){
            dp[1][s] = 1;
        }

        for(int i=2;i<=n;i++){
            for (int s = i; s <= 6 * i; s++) {
                for (int d = 1; d <= 6; d++) {
                    if (s - d < i - 1) {
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] ans = new double[5*n+1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }
}
