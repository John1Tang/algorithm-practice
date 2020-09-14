package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 94. Binary Tree Inorder Traversal
 * @author: john
 * @created: 2020/09/14 22:07
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Lc0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // move toward the left for one step, and keep moving toward the right
                predecessor = root.left;

                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // right pointer as root, keep iterate the left tree
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // unlink the left child tree
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // if no child node on the left, directly access the right child node
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
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
