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
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
	preorder(root);
	return min;
    }
    public void preorder(TreeNode root) {
	if (root == null) {
	    return;
	}
	preorder(root.left);
	if (prev == null) {
	    prev = root.val;
	} else {
	    min = Math.min(min, root.val - prev);
	    prev = root.val;
	}
	preorder(root.right);
    }
}
