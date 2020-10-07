package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 834. Sum of Distances in Tree
 * @author: john
 * @created: 2020/10/07 23:42
 *
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 *
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 *
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 *
 * Example 1:
 *
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Note: 1 <= N <= 10000
 *
 *
 */
public class Lc0834 {
    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for(int v: graph.get(u)) {
            if(v == f){
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f) {
        ans[u] = dp[u];
        for (int v: graph.get(u)) {
            if(v == f) {
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}
