/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    	if (root == null) {
		return;
	}
	Queue<TreeLinkNode> queue = new LinkedList<>();
	queue.add(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		TreeLinkNode prev = null;
		for (int i = 0; i < size; i++) {
			TreeLinkNode cur = queue.poll();
			if (cur.right != null) {
				queue.add(cur.right);
			}
			if (cur.left != null) {
				queue.add(cur.left);
			}
			cur.next = prev;
			prev = cur;
		}
	}
    }
}
