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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
	if (root == null) {
		return res;
	}
	res.add(root.val);
	leftBoundary(root.left, res);
	leaves(root.left, res);
	leaves(root.right, res);
	rightBoundary(root.right, res);
	return res;
    }
    public void leftBoundary(TreeNode root, List<Integer> left) {
	if (root == null || (root.left == null && root.right == null)) {
		return;
	}
	left.add(root.val);
	if (root.left != null) {
		leftBoundary(root.left, left);
	} else {
		leftBoundary(root.right, left);
	}
    }
    public void rightBoundary(TreeNode root, List<Integer> right) {
	if (root == null || (root.left == null && root.right == null)) {
		return;
	}
	if (root.right != null) {
		rightBoundary(root.right, right);
	} else {
		rightBoundary(root.left, right);
	}
	right.add(root.val);
    }
    public void leaves(TreeNode root, List<Integer> leave) {
    	if (root == null) {
		return;
	}
	if (root.left == null && root.right == null) {
		leave.add(root.val);
	}
	leaves(root.left, leave);
	leaves(root.right, leave);
    }
}
