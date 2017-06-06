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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	helper(root);
	return max;
    }
    public void helper(TreeNode root) {
    	if (root == null) {
		return;
	}
	max = Math.max(max, depth(root.left) + depth(root.right));
	helper(root.left);
	helper(root.right);
    }
    public int depth(TreeNode root) {
    	if (root == null) {
		return 0;
	}
	int left = depth(root.left);
	int right = depth(root.right);
	return Math.max(1 + left, 1 + right);
    }
}
