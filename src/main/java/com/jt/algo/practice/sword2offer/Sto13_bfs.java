package com.jt.algo.practice.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 面试题13. 机器人的运动范围
 * @author: john
 * @created: 2020/05/14 23:10
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 */
public class Sto13_bfs {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }

}
