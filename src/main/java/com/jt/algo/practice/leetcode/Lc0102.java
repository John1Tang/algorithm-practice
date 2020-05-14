package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 102. Binary Tree Level Order Traversal
 * @author: john
 * @created: 2020/05/14 21:28
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Lc0102 {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        inorderTraverse(root, 0);
        return res;
    }

    public void inorderTraverse(TreeNode node, int level){
        if(node != null){
            if(res.size() == level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            inorderTraverse(node.left, level + 1);
            inorderTraverse(node.right, level + 1);
        }
    }
}
