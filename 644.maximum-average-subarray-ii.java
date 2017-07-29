public class Solution {
    public double findMaxAverage(int[] nums, int k) {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	for (int num : nums) {
	    min = Math.min(num, min);
	    max = Math.max(num, max);
	}
	double lo = min;
	double hi = max;
	while (hi - lo > 1e-5) {
	    double mid = (hi + lo) / 2;
	    if (check(nums, k, mid)) {
	    	lo = mid;
	    } else {
		hi = mid;
	    }
	}
	return lo;
    }
    public boolean check(int[] nums, int k, double val) {
	double[] arr = new double[nums.length];
	for (int i = 0; i < arr.length; i++) {
	    arr[i] =nums[i] - val;
	}
	double sum = 0;
	for (int i = 0; i < k; i++) {
	    sum += arr[i];
	}
	if (sum >= 0) {
	    return true;
	}
	double sum2 = 0;
	double min = 0;
	for (int i = k; i < arr.length; i++) {
	    sum += arr[i];
	    sum2 += arr[i - k];
	    min = Math.min(min, sum2);
	    if (sum - min >= 0) {
		return true;
	    }
	}
	return false;
    }
}
