public class Solution {
    public int searchInsert(int[] nums, int target) {
	int lo = 0;
	int hi = nums.length - 1;
	while (lo + 1 < hi) {
	    int mid = (lo + hi) >>> 1;
	    if (target > nums[mid]) {
		lo = mid;
	    } else if (target == nums[mid]) {
		return mid;
	    } else {
		hi = mid;
	    }
	}
	if (nums[hi] == target) {
	    return hi;
	} else if (nums[hi] < target) {
	    return hi + 1;
	}

	if (nums[lo] == target) {
	    return lo;
	} else if (nums[lo] < target) {
	    return lo + 1;
	}
	return 0;
    }
}
