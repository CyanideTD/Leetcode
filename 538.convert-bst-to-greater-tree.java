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
    public TreeNode convertBST(TreeNode root) {
    	helper(root);
	return root;
    }
    int sum = 0;
    public void helper(TreeNode root) {
    	if (root == null) {
		return;
	}
	helper(root.right);
	int temp = sum;
	sum += root.val;
	root.val += temp;
	helper(root.left);
    }
}
