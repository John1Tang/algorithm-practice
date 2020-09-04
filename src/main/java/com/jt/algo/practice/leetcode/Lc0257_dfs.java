package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 257. Binary Tree Paths
 * @author: john
 * @created: 2020/09/04 23:04
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Lc0257_dfs {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPath(root, "", paths);
        return paths;
    }

    public void constructPath(TreeNode root, String path, List<String> paths) {
        if (null != root) {
            StringBuffer pathSb = new StringBuffer(path);
            pathSb.append(Integer.toString(root.val));

            if (null == root.left && null == root.right) {
                paths.add(pathSb.toString());
            } else {
                pathSb.append("->");
                constructPath(root.left, pathSb.toString(), paths);
                constructPath(root.right, pathSb.toString(), paths);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
