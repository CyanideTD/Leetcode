class TreeNode {
    int val;
    int index;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, int index) {
	this.val = val;
	this.index = index;	
    }	
}
public class Solution {
    private TreeNode insert(TreeNode root, int val, int index) {
	if (root == null) {
	    root = new TreeNode(val, index);
	} else if (root.val > val) {
	    root.left = insert(root.left, val, index);
	} else if (root.val < val) {
	    root.right = insert(root.right, val, index);
	}
	return root;
    }

    private TreeNode search(TreeNode root, int val, TreeNode prev) {
	if (root == null) {
	    return prev;
	}
	if (root.val > val) {
	    prev = root;
	    return search(root.left, val, prev);
	} else {
	    return search(root.right, val, prev);
	}
    }
    public void nextPermutation(int[] nums) {
	TreeNode root = null;
	for (int i = nums.length - 1; i >= 0; i--) {
	    TreeNode swap = search(root, nums[i], null);
	    if (swap != null) {
		int temp = nums[i];
	  	nums[i] = swap.val;
		nums[swap.index] = temp;
	 	Arrays.sort(nums, i + 1, nums.length);
		return;	
	    }
	    root = insert(root, nums[i], i);
	}
	for (int i = 0; i < nums.length / 2; i++) {
	    int temp = nums[i];
	    nums[i] = nums[nums.length - i - 1];
	    nums[nums.length - i - 1] = temp;
	}
    }
}
