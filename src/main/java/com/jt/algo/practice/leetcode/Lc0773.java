package com.jt.algo.practice.leetcode;

import java.util.*;

/**
 * @description: 773. Sliding Puzzle
 * @author: john
 * @created: 2021/06/27 21:43
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 *
 */
public class Lc0773 {
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        PriorityQueue<AStar1> pq = new PriorityQueue<AStar1>((a, b) -> a.f - b.f);
        pq.offer(new AStar1(initial, 0));
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!pq.isEmpty()) {
            AStar1 node = pq.poll();
            for (String nextStatus : get(node.status)) {
                if (!seen.contains(nextStatus)) {
                    if ("123450".equals(nextStatus)) {
                        return node.g + 1;
                    }
                    pq.offer(new AStar1(nextStatus, node.g + 1));
                    seen.add(nextStatus);
                }
            }
        }

        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

class AStar1 {
    // 曼哈顿距离
    public static int[][] dist = {
            {0, 1, 2, 1, 2, 3},
            {1, 0, 1, 2, 1, 2},
            {2, 1, 0, 3, 2, 1},
            {1, 2, 3, 0, 1, 2},
            {2, 1, 2, 1, 0, 1},
            {3, 2, 1, 2, 1, 0}
    };

    public String status;
    public int f, g, h;

    public AStar1(String status, int g) {
        this.status = status;
        this.g = g;
        this.h = getH(status);
        this.f = this.g + this.h;
    }

    // 计算启发函数
    public static int getH(String status) {
        int ret = 0;
        for (int i = 0; i < 6; ++i) {
            if (status.charAt(i) != '0') {
                ret += dist[i][status.charAt(i) - '1'];
            }
        }
        return ret;
    }
}
