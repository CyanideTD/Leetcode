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
    public boolean isValidBST(TreeNode root) {
    	return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean helper(TreeNode root, long max, long min) {
    	if (root == null) {
		return true;
	}
	boolean left = helper(root.left, root.val, min);
	boolean right = helper(root.right, max, root.val);
	if (root.val >= max || root.val <= min) {
		return false;
	}
	return left && right;
    }
}
