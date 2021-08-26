package com.jt.algo.practice.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 743. Network Delay Time
 * @author: john
 * @created: 2021/08/03 22:58
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *  
 *
 * Constraints:
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 *
 */
public class Lc0743 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[] {y, t[2]});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[] {0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[] {d, y});
                }
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        /**
         * [[2,1,1],[2,3,1],[3,4,1]]
         * 4
         * 2
         */
        System.out.println(networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2));
    }
}
