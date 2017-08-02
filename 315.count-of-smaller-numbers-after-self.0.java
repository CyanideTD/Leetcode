public class Solution {

    private int lowbit(int val) {
	return val & (-val);	
    }

    private void insert(int[] bit, int index) {
	while (index < bit.length) {
	    bit[index] += 1;
	    index += lowbit(index);
	}	
    }

    private int search(int[] bit, int index) {
	int sum = 0;
	while (index > 0) {
	    sum += bit[index];
	    index -= lowbit(index);
	}	
	return sum;
    }

    private int index(int[] nums, int val) {
	int lo = 0;
	int hi = nums.length - 1;
	while (lo + 1 < hi) {
	    int mid = (lo + hi) >>> 1;
	    if (val > nums[mid]) {
		lo = mid;
	    } else if (val <= nums[mid]) {
		hi = mid;
	    }
	}
	if (nums[hi] <= val) {
	    return hi + 1;
	} else if (nums[lo] <= val) {
	    return lo + 1;
	} else {
	    return 0;
	}
    }

    public List<Integer> countSmaller(int[] nums) {
	List<Integer> res = new LinkedList<>();
	int[] bit = new int[nums.length];
	int[] copy = Arrays.copyOf(nums, nums.length);
	Arrays.sort(copy);
	for (int i = nums.length - 1; i >= 0; i--) {
	    res.add(0, search(bit, index(copy, nums[i]) - 1));
	    insert(bit, index(copy, nums[i]));
	}
	return res;
    }
}

