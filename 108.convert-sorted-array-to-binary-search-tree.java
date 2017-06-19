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
    public TreeNode sortedArrayToBST(int[] nums) {
    	TreeNode root = builder(nums, 0, nums.length - 1);
	return root;
    }
    public TreeNode builder(int[] nums, int L, int R) {
	if (L > R) {
		return null;
	}
    	int mid = (L + R) >>> 1;
	TreeNode root = new TreeNode(nums[mid]);
	TreeNode left = builder(nums, L, mid - 1);
	TreeNode right = builder(nums, mid + 1, R);
	root.left = left;
	root.right = right;
	return root;
    }
}
