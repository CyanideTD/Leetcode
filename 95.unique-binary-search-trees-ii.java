/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
	if (n == 0) {
	    return new ArrayList<TreeNode>();
	}
	return build(1, n);
    }
    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> nodes = new ArrayList<>();
	if (lo > hi) {
	    nodes.add(null);
	    return nodes;
	}

	for (int i = lo; i <= hi; i++) {
	    List<TreeNode> left = build(lo, i - 1);
	    List<TreeNode> right = build(i + 1, hi);
	    for (int j = 0; j < left.size(); j++) {
	        for (int k = 0; k < right.size(); k++) {
		    TreeNode node = new TreeNode(i);
	 	    node.left = left.get(j);
		    node.right = right.get(k);
		    nodes.add(node);
		}
	    }
	}
	return nodes;
    }
}
