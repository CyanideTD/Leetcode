/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Node {
    int index;
    int val;
    public Node(int val, int index) {
	this.val = val;
	this.index = index;	
    }	
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
	if (lists == null || lists.length == 0) {
	    return null;
	}
	PriorityQueue<Node> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	for (int i = 0; i < lists.length; i++) {
	    if (lists[i] != null) {
	        pq.add(new Node(lists[i].val, i));
	    }
	}
	
	while (!pq.isEmpty()) {
	    Node poll = pq.poll();
	    cur.next = lists[poll.index];
	    lists[poll.index] = lists[poll.index].next;
	    if (lists[poll.index] != null) {
		pq.add(new Node(lists[poll.index].val, poll.index));
	    }
	    cur = cur.next;
	}
	return dummy.next;
    }
}
