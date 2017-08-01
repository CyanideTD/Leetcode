public class Solution {
    class TreeNode {
	long val;
	TreeNode left;
	TreeNode right;
	int cnt;
	public TreeNode(long val) {
	    this.val = val;
	    this.cnt = 0;
	}	
    }

    private TreeNode insert(TreeNode root, long val) {
	if (root == null) {
	    root = new TreeNode(val);
	} else if (root.val > val) {
	    root.left = insert(root.left, val);
	} else if (root.val <= val) {
	    root.right =  insert(root.right, val);
	}
	root.cnt += 1;
	return root;
    }

    private int search(TreeNode root, long val) {
	if (root == null) {
	    return 0;
	}
	if (root.val == val) {
	    return root.cnt - (root.left != null ? root.left.cnt : 0);    
	} else if (root.val > val) {
	    if (root.right != null) {
		return root.right.cnt + 1 + search(root.left, val);
	    } else {
		return 1 + search(root.left, val);
	    }
	} else {
	    return search(root.right, val);
	}
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
	if (nums == null || nums.length == 0) {
	    return 0;
	}
	long[] sum = new long[nums.length + 1];
	sum[0] = nums[0];
	for (int i = 1; i < sum.length; i++) {
	    sum[i] = sum[i - 1] + nums[i - 1];
	}
	TreeNode root = null;
	int count = 0;
	for (int i = nums.length; i >= 1; i--) {
	    root = insert(root, sum[i]);
	    count += (search(root, lower + sum[i - 1]) - search(root, upper + sum[i - 1] + 1));
	}
	return count;
    }
}
