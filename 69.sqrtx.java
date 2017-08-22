class Solution {
    public int mySqrt(int x) {
	if (x < 0) {
	    return -1;
	}        
	if (x == 0) {
	    return 0;
	}
	int lo = 1;
	int hi = x;
	while (lo + 1 < hi) {
	    int mid = (hi + lo) >>> 1;
	    if (mid > x / mid) {
		hi = mid;
	    } else if (mid < x/ mid) {
		lo = mid;
	    } else {
		return mid;
	    }
	}
	if (hi < x / hi) {
	    return hi;
	} else {
	    return lo;
	}
    }
}
