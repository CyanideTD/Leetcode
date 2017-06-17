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
    int max = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
    	inorder(root);
	return max;
    }
    public void inorder(TreeNode root) {
    	if (root == null) {
		return;
	}
	inorder(root.left);
	if (prev != null) {
		max = Math.min(max, root.val - prev);
	}
	prev = root.val;
	inorder(root.right);
    }
}
