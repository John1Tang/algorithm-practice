package com.jt.algo.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 101. Symmetric Tree
 * @author: john
 * @created: 2020/05/31 21:19
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * Follow up: Solve it both recursively and iteratively.
 */
public class Lc0101_iterate {
    public boolean isSymmetric(TreeNode root){
        return check(root, root);
    }
    public boolean check(TreeNode u, TreeNode v){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while(!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if(u == null && v == null){
                continue;
            }
            if((u==null || v == null) || (u.val != v.val)){
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
