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
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	    if (isSame(s, t)) {
	    	return true;
	    }
	    boolean left = false;
	    boolean right = false;
	    if (s != null) {
	    	left = isSubtree(s.left, t);
		right = isSubtree(s.right, t);
	    }
	    return left || right;
    }
    public boolean isSame(TreeNode s, TreeNode t) {
    	if (s == null && t == null) {
		return true;
	}
	if (s == null || t == null) {
		return false;
	}
	if (s.val != t.val) {
		return false;
	}
	return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
