package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 447. Number of Boomerangs
 * @author: john
 * @created: 2021/09/13 23:13
 *
 *
 *You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Return the number of boomerangs.
 *
 *  
 *
 * Example 1:
 *
 * Input: points = [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
 * Example 2:
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 2
 * Example 3:
 *
 * Input: points = [[1,1]]
 * Output: 0
 *  
 *
 * Constraints:
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 *
 */
public class Lc0447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
