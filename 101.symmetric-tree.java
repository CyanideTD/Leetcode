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
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
		return true;
	}
	return isSame(root.left, root.right);
    }
    public boolean isSame(TreeNode p, TreeNode q) {
    	if (p == null && q == null) {
		return true;
	}
	if (p == null || q == null) {
		return false;
	}
	if (p.val != q.val) {
		return false;
	}
	boolean left = isSame(p.left, q.right);
	boolean right = isSame(p.right, q.left);
	return left && right;
    }
}
