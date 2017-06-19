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
    class ResultType {
    	boolean isBalanced;
	int height;
	public ResultType(boolean balance, int h) {
		isBalanced = balance;
		height = h;
	}
    }
    public boolean isBalanced(TreeNode root) {
    	ResultType res = height(root);
        return res.isBalanced;	
    }
    public ResultType height(TreeNode root) {
    	if (root == null) {
		return new ResultType(true, 0);
	}
	ResultType left = height(root.left);
	ResultType right = height(root.right);
	if (left.isBalanced && right.isBalanced) {
		if (Math.abs(left.height - right.height) > 1) {
			return new ResultType(false, 0);
		}
		int h = Math.max(left.height, right.height) + 1;
		return new ResultType(true, h);
	} else {
		return new ResultType(false, 0);
	}
    }
}
