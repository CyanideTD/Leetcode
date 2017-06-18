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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
    	if (root == null) {
		return;
	}
	traverse(root);
	int temp = first.val;
	first.val = second.val;
	second.val = temp;
    }
    public void traverse(TreeNode root) {
    	if (root == null) {
		return;
	}
	traverse(root.left);
	if (prev != null) {
		if (root.val < prev.val) {
			if (first == null) {
				first = prev;
				second = root;
			} else {
				second = root;
			}
		}
	}
	prev = root;
	traverse(root.right);
    }

}
