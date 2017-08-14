public class Solution {
    public int[] searchRange(int[] nums, int target) {
	int[] res = new int[2];
	Arrays.fill(res, -1);
	if (nums == null || nums.length == 0) {
	    return res;
	}
	int hi = nums.length - 1;
	int lo = 0;
	while (lo + 1 < hi) {
	    int mid = (hi + lo) >>> 1;
	    if (nums[mid] >= target) {
		hi = mid;
	    } else if (nums[mid] < target) {
		lo = mid;
	    }
	}
	if (nums[lo] == target) {
	    res[0] = lo;
	} else if (nums[hi] == target) {
	    res[0] = hi;
	}

	hi = nums.length - 1;
	lo = 0;
	while (lo + 1 < hi) {
	    int mid = (lo + hi) >>> 1;
	    if (nums[mid] > target) {
		hi = mid;
	    } else {
		lo = mid;	
	    }
	}
	if (nums[hi] == target) {
	    res[1] = hi;
	} else if (nums[lo] == target) {
	    res[1] = lo;
	}
	return res;
    }
}
