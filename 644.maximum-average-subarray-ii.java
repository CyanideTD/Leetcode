public class Solution {
    public double findMaxAverage(int[] nums, int k) {
	int lo = Integer.MAX_VALUE;
	int hi = Integer.MIN_VALUE;
	for (int num : nums) {
	    lo = Math.min(num, lo);
	    hi = Math.max(num, hi);
	}
	double low = lo;
	double high = hi;
	while (high - low > 1e-6 ) {
	    double mid = (high + low) / 2.0;
	    if (check(nums, k, mid)) {
		low = mid;
	    } else {
		high = mid;
	    }
	}
	return high;
    }
    private boolean check(int[] nums, int k, double avg) {
	double[] arr = new double[nums.length];
	double sum = 0;
	for (int i = 0; i < nums.length; i++) {
	    arr[i] = nums[i] - avg;
	}
	
	for (int i = 0; i < k; i++) {
	    sum += arr[i];
	}
	if (sum >= 0) {
	    return true;
	}
	double sum2 = 0;
	double min = 0;
	for (int i = k; i < nums.length; i++) {
	    sum2 += arr[i - k];
	    sum += arr[i];
	    min = Math.min(min, sum2);
	    if (sum - min >= 0) {
		return true;
	    }
	}
	return false;
    }
}
