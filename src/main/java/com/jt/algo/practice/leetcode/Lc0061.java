package com.jt.algo.practice.leetcode;

/**
 * @description: 61. Rotate List
 * @author: john
 * @created: 2021/03/28 18:37
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Lc0061 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            System.out.println("iter001: " + iter.val);
            n++;
        }
        int add = n - k % n;
        System.out.println("add: " + add + ", n: " + n);
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
            System.out.println("iter002: " + iter.val);
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        [1,2,3,4,5]
//        2
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        rotateRight(listNode, 2);
    }
}
