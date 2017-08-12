/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode first = dummy;
	ListNode second = dummy;
	while (n >= 0 && second != null) {
	    second = second.next;
	    n--;
	}
	while (second != null) {
	    first = first.next;
	    second = second.next;
	}
	first.next = first.next.next;
	return dummy.next;
    }
}
