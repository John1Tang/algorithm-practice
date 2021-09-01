package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 802. Find Eventual Safe States
 * @author: john
 * @created: 2021/08/30 11:45
 *
 * We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a terminal node (that is, it has no outgoing directed edges), we stop.
 *
 * We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Example 2:
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 *  
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 *
 *
 */
public class Lc0802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
