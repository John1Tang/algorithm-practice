package com.jt.algo.practice.leetcode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Lc0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode before = new ListNode(0);

        ListNode now = before;

        int carry = 0;
        while (null != l1 || null != l2) {
            int x = null != l1 ? l1.val : 0;
            int y = null != l2 ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            now.next = new ListNode(sum);

            now = now.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            now.next = new ListNode(carry);
        }
        return before.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}