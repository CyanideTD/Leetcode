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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (root == null) {
		return res;
	}
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		List<Integer> level = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			TreeNode cur = queue.poll();
			level.add(cur.val);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
		res.add(new ArrayList(level));
	}
	return res;
    }
}
