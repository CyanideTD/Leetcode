public class Solution {
    class TreeNode {
	int val;
	int cnt;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
	    this.val = val;
	    this.cnt = 0;
	}	
    }
	
    private TreeNode insert(TreeNode root, int val) {
	if (root == null) {
	    root = new TreeNode(val);
	} else if (root.val <= val) {
	    root.right = insert(root.right, val);
	} else {
	    root.left = insert(root.left, val);
	}
	root.cnt += 1;
	return root;
    }

    private int search(TreeNode root, int val) {
	if (root == null) {
	    return 0;
	} else if (root.val > val) {
	    return search(root.left, val);
	} else if (root.val < val) {
	    int left = root.left == null ? 0 : root.left.cnt;
	    return left + 1 + search(root.right, val);
	} else {
	    int left = root.left == null ? 0 : root.left.cnt;
	    return left;
	}
    }

    public List<Integer> countSmaller(int[] nums) {
	TreeNode root = null;
	List<Integer> res = new LinkedList<>();
	for (int i = nums.length - 1; i >= 0; i--) {
	    int num = nums[i];
	    res.add(0, search(root, num));
	    root = insert(root, num);
	}
	return res;
    }
}
