public class Solution {
    public int maxArea(int[] height) {
	int max = Integer.MIN_VALUE;
	int lo = 0;
	int hi = height.length - 1;
	while (lo < hi) {
	    max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
	    if (height[lo] > height[hi]) {
		hi--;
	    } else {
		lo++;
	    }
	}
	return max;
    }
}
