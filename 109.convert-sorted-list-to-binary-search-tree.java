/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
	    return null;
	}
	int length = 0;
	ListNode node = head;
	while (node != null) {
	    node = node.next;
	    length++;
	}
	return build(head, length);
    }

    public TreeNode build(ListNode head, int length) {
        if (length <= 0) {
	    return null;
	}
	int pos = length / 2;
	ListNode node = head;
	for (int i = 0; i < pos; i++) {
	    node = node.next;
	}
	TreeNode tree = new TreeNode(node.val);
	tree.left = build(head, pos);
	tree.right = build(node.next, length - pos - 1);
	return tree;
    }
}
