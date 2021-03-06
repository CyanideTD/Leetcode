class TreeNode {
    int val;
    int cnt;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
	this.val = val;
	this.cnt = 1;	
    }
}
public class Solution {
    public int reversePairs(int[] nums) {
	int[] copy = Arrays.copyOf(nums, nums.length);
	Arrays.sort(copy);
	int[] bit = new int[nums.length + 1];
	int sum = 0;
	for (int i = nums.length - 1; i >= 0; i--) {
	    sum += search(bit, index(copy,(long) nums[i] / 2));
	    update(bit, index(copy,(long) nums[i]));
	}
	return sum;
    }
    public int search(int[] bit, int i) {
	int sum = 0;
	while (i > 0) {
	    sum += bit[i];
	    i -= lowbit(i);
	}
	return sum;
    }
    public int lowbit(int val) {
	return val & (-val);	
    }
    public void update(int[] bit, int i) {
	while (i < bit.length) {
	    bit[i] += 1;
	    i += lowbit(i);
	}
    }
    public int index(int[] nums, long val) {
	int l = 0;
	int r = nums.length - 1;
	while (l + 1 < r) {
	    int mid = (l + r) >> 1;
	    if (nums[mid] > val) {
		r = mid;
	    } else if (nums[mid] <= val) {
		l = mid;
	    }
	}
	if (nums[r] <= val) {
	    return r + 1;
	} else {
	    return l + 1;
	}
    }
}
