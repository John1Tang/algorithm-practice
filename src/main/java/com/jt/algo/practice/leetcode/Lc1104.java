package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 1104. Path In Zigzag Labelled Binary Tree
 * @author: john
 * @created: 2021/07/29 23:41
 *
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 *
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 *
 *  
 *
 * Example 1:
 *
 * Input: label = 14
 * Output: [1,3,4,14]
 * Example 2:
 *
 * Input: label = 26
 * Output: [1,2,6,10,26]
 *  
 *
 * Constraints:
 *
 * 1 <= label <= 10^6
 *
 *
 */
public class Lc1104 {
    public static List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public static int getReverse (int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }

    public static void main(String[] args) {
        pathInZigZagTree(14).forEach(System.out::println);
    }
}
