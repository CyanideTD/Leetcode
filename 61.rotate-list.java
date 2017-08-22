/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
	if (head == null) {
	    return null;
	}
	if (k == 0) {
	    return head;
	}
	int length = 0;
	ListNode node = head;
	while (node != null) {
	    node = node.next;
	    length++;
	}
	k = k % length;
	if (k == 0) {
	    return head;
	}
	ListNode first = head;
	for (int i = 0; i < k; i++) {
	    first = first.next;
	}
	ListNode second = head;
	while (first.next != null) {
	    second = second.next;
	    first = first.next;
	}
	ListNode newHead = second.next;
	first.next = head;
	second.next = null;
	return newHead;
    }
}
