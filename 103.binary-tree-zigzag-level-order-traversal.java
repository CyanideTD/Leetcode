/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	Deque<TreeNode> queue = new ArrayDeque<>();
	Deque<TreeNode> stack = new ArrayDeque<>();
	List<List<Integer>> res = new ArrayList<>();
	if (root == null) {
	    return res;
	}

	queue.offer(root);
	while (!queue.isEmpty() || !stack.isEmpty()) {
	    List<Integer> list = new ArrayList<>();
	    if (!queue.isEmpty()) {
	    	while (!queue.isEmpty()) {
		    TreeNode node = queue.removeFirst();
		    list.add(node.val);
		    if (node.left != null) {
		        stack.addLast(node.left);
		    }
		    if (node.right != null) {
		    	stack.addLast(node.right);
		    }
		}
	    } else {
		while (!stack.isEmpty()) {
		    TreeNode node1 = stack.removeLast();
		    list.add(node1.val);
		    if (node1.right != null) {
		        queue.addFirst(node1.right);
		    }
		    if (node1.left != null) {
		        queue.addFirst(node1.left);
		    }
		}
	    }
	    res.add(list);
	}

	return res;
    }
}
