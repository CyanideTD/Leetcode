public class Solution {
    public int search(int[] nums, int target) {
	if (nums == null || nums.length == 0) {
	    return -1;
	}
	int hi = nums.length - 1;
	int lo = 0;
	while (lo + 1 < hi) {
	    int mid = (hi + lo) >>> 1;
	    if (nums[mid] > nums[hi]) {
		lo = mid;
	    } else {
		hi = mid;
	    }
	}
	int lowest = -1;
   	if (nums[lo] > nums[hi]) {
	    lowest = hi;
	} else {
	    lowest = lo;
	}

	hi = nums.length - 1;
	lo = 0;
	if (lowest == 0) {
	    return binarySearch(nums, 0, nums.length - 1, target);
	} else if (nums[0] <= target) {
	    return binarySearch(nums, 0, lowest - 1, target);
	} else {
	    return binarySearch(nums, lowest, nums.length - 1, target);
	}
    }
    public int binarySearch(int[] nums, int left, int right, int target) {
	while (left + 1 < right) {
	    int mid = (left + right) >>> 1;
	    if (target > nums[mid]) {
		left = mid;
	    } else if (nums[mid] > target) {
		right = mid;
	    } else {
		return mid;
	    }
	}
	if (nums[left] == target) {
	    return left;
	} else if (nums[right] == target) {
	    return right;
	}
	return -1;
    }
}
