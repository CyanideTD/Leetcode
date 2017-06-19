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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	Map<Integer, Integer> hm = new HashMap<>();
	for (int i = 0; i < inorder.length; i++) {
		hm.put(inorder[i], i);
	}
	TreeNode root = builder(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, hm);
	return root;
    }
    public TreeNode builder(int[] post, int L, int R, int[] inorder, int l, int r, Map<Integer, Integer> hm) {
    	if (l > r || L > R) {
		return null;
	}
	TreeNode root = new TreeNode(post[R]);
	int index = hm.get(post[R]);
	TreeNode left = builder(post, L, R - r + index - 1, inorder, l, index - 1, hm);
	TreeNode right = builder(post, R - (r - index), R - 1, inorder, index + 1, r, hm);
	root.left = left;
	root.right = right;
	return root;
    }
}
