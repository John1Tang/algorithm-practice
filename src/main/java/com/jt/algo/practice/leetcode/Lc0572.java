package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 572. Subtree of Another Tree
 * @author: john
 * @created: 2020/05/07 23:29
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *  
 * <p>
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class Lc0572 {
    List<Integer> sOrder, tOrder;
    private int maxElement = Integer.MIN_VALUE;
    private int lNull, rNull;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            if (s == t) {
                return true;
            }
            return false;
        }
        sOrder = new ArrayList<>();
        tOrder = new ArrayList<>();

        getMaxElement(s);
        getMaxElement(t);

        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    private void getMaxElement(TreeNode root) {
        if (root == null) {
            return;
        }
        maxElement = Math.max(maxElement, root.val);
        getMaxElement(root.left);
        getMaxElement(root.right);
    }

    private void getDfsOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        if (root.left != null) {
            getDfsOrder(root.left, list);
        } else {
            list.add(lNull);
        }

        if (root.right != null) {
            getDfsOrder(root.right, list);
        } else {
            list.add(rNull);
        }
    }

    private boolean kmp() {
        int sLen = sOrder.size();
        int tLen = tOrder.size();
        int[] next = new int[tLen];

        Arrays.fill(next, -1);

        int i = 0, k = -1, j = 0;
        while (j < tLen - 1) {
            if (k == -1 || tOrder.get(j).equals(tOrder.get(k))) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        j = 0;
        while (i < sLen && j < tLen) {
            if (j == -1 || sOrder.get(i).equals(tOrder.get(j))) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        return j == tLen;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
