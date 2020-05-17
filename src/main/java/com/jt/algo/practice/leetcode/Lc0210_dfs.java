package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 210. Course Schedule II
 * @author: john
 * @created: 2020/05/17 23:07
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 */
public class Lc0210_dfs {
    private int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisities){
        if(numCourses == 0){
            return new int[0];
        }
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }

        for(int[] pre : prerequisities){
            in[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0){
                ans[count++] = i;
                in[i] = -1;
                dfs(edges, edges[i], in, ans);
            }
        }
        return count == numCourses ? ans : new int[0];
    }

    public void dfs(List[] edges, List<Integer> list, int[] in, int[] ans){
        for(int terminus : list){
            in[terminus]--;
            if(in[terminus] == 0){
                ans[count++] = terminus;
                in[terminus] = -1;
                dfs(edges, edges[terminus], in, ans);
            }
        }
    }
}
