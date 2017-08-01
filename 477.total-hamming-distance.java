public class Solution {
    public int totalHammingDistance(int[] nums) {
	int res = 0;
	int[] count = new int[2];
	int zeroCount = 0;
	while (true) {
	    zeroCount = 0;
	    count[0] = 0;
	    count[1] = 0;
	    for (int i = 0; i < nums.length; i++) {
		if (nums[i] == 0) {
		    zeroCount++;
	   	}
		count[nums[i] % 2]++;
 		nums[i] /= 2;
	    }
	    res += count[0] * count[1];
	    if (zeroCount == nums.length) {
		return res;
	    }
	}
    }

}
