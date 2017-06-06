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
    public int longestConsecutive(TreeNode root) {
        helper(root);
	return max;
    }
    public int[] helper(TreeNode root) {
    	if (root == null) {
		return new int[2];
	}
	int[] left = helper(root.left);
	int[] right = helper(root.right);

	int inc = 1;
	int dec = 1;
	if (root.left != null) {
		if (root.val == root.left.val + 1) {
			inc += left[0];
		} else if (root.val == root.left.val - 1) {
			dec += left[1];
		}
	}
	if (root.right != null) {
		if (root.val == root.right.val + 1) {
			inc = Math.max(inc, right[0] + 1);
		} else if (root.val == root.right.val - 1) {
			dec = Math.max(dec, right[1] + 1);
		}
	}
	max = Math.max(max, inc + dec - 1);
	int[] res = new int[2];
	res[0] = inc;
	res[1] = dec;
	return res;
    }
}
