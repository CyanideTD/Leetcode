public class Solution {
    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	int size;
	public TreeNode(int val) {
	    this.val = val;
	    this.size = 0;
	}	
    }

    private void insert(TreeNode root, int val) {
	if (root == null) {
	    root = new TreeNode(val);
	} else if (root.val > val) {
	    root.right = insert(root.left, val);
	} else if (root.val < val) {
	    root.left =  insert(root.right, val);
	}
	root.size += 1;
	return root;
    }

    private int search(TreeNode root, int val) {
	if (root.val == val) {
	   
	} else if (root.val > val) {
	   
	} else {
	    
	}
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
		
    }
}
