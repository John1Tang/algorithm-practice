package com.jt.algo.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 23. Merge k Sorted Lists
 * @author: john
 * @created: 2020/04/26 22:12
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Lc0023_minHeap {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pg = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

        for (ListNode node : lists) {
            if (node != null) {
                pg.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pg.isEmpty()) {
            ListNode minNode = pg.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pg.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
