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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if (root == null) {
		return res;
	}
	Queue<TreeNode> queue = new ArrayDeque<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			TreeNode cur = queue.poll();
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
			temp.add(cur.val);
		}
		res.add(0, temp);
	}
	return res;
    }
}
