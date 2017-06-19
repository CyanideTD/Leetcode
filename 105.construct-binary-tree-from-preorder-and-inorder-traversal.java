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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	    Map<Integer, Integer> hm = new HashMap<>();
	    for (int i = 0; i < inorder.length; i++) {
	    	hm.put(inorder[i], i);
	    }
	    TreeNode root = builder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
	    return root;
    }
    public TreeNode builder(int[] preorder, int L, int R, int[] inorder, int l, int r, Map<Integer, Integer> hm) {
    	if (L > R || l > r) {
		return null;
	}
	TreeNode root = new TreeNode(preorder[L]);
	int index = hm.get(preorder[L]);
	TreeNode left = builder(preorder, L + 1, index - l + L, inorder, l, index - 1, hm);
	TreeNode right = builder(preorder, index - l + L + 1, R, inorder, index + 1, r, hm);
	root.left = left;
	root.right = right;
	return root;
    }
}
