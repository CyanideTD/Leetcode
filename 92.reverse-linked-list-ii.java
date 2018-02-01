/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
	ListNode dummy = new ListNode(0);
	if (head == null) {
	    return null;
	}
	if (m == n) {
	    return head;
	}
	dummy.next = head;
	ListNode current = dummy;
	for (int i = 1; i < m; i++) {
	    current = current.next;
	}

	ListNode start = current;
	ListNode prev = null;
	current = current.next;
	ListNode next = current.next;
	for (int i = 0; i <= n - m; i++) {
	    current.next = prev;
	    prev = current;
	    current = next;
	    if (next == null) {
	        break;
	    }
	    next = next.next;
	}
	start.next.next = current;
	start.next = prev;
	return dummy.next;
    }
}
