/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
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