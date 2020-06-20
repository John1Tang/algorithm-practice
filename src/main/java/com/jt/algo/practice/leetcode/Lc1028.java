package com.jt.algo.practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 1028. Recover a Tree From Preorder Traversal
 * @author: john
 * @created: 2020/06/20 21:47
 *
 * We run a preorder depth first search on the root of a binary tree.
 *
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 *
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output S of this traversal, recover the tree and return its root.
 *
 *  
 *
 * Example 1:
 *
 *
 *
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 *
 *
 *
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 *  
 *
 * Example 3:
 *
 *
 *
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 *  
 *
 * Note:
 *
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
 *
 */
public class Lc1028 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while(pos < S.length()){
            int level = 0;
            while(S.charAt(pos) == '-'){
                ++level;
                ++pos;
            }
            int value = 0;
            while(pos < S.length() && Character.isDigit(S.charAt(pos))){
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if(level == path.size()){
                if(!path.isEmpty()){
                    path.peek().left = node;
                }
            }else{
                while(level != path.size()){
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while(path.size() > 1){
            path.pop();
        }
        return path.peek();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
