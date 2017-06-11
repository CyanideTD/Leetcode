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
    public TreeNode str2tree(String s) {
	ArrayDeque<TreeNode> parents = new ArrayDeque<>();
	int length = s.length();
	int i = 0;
	while (i < length) {
		char cur = s.charAt(i);
		int flag = 1;
		if (cur == '(') {
			i++;
		} else if (cur == ')') {
			TreeNode node = parents.pollFirst();
			TreeNode parent = parents.peekFirst();
			if (parent.left == null) {
				parent.left = node;
			} else {
				parent.right = node;
			}
			i++;
		} else {
			if (cur == '-') {
				flag = -1;
				i++;
				cur = s.charAt(i);
			}
			int num = 0;
			while (i < length && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				num = num * 10 + s.charAt(i) - '0';
				i++;
			}
			num = num * flag;
			TreeNode node = new TreeNode(num);
			parents.addFirst(node);
		}
	}
	TreeNode root = parents.pollFirst();
	return root;
    }
}
