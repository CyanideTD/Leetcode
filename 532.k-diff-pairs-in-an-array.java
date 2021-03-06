public class Solution {
    public int findPairs(int[] nums, int k) {
    	int res = 0;
	if (nums == null || nums.length < 2) {
		return 0;
	}
	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++) {
		if (i != 0 && nums[i] == nums[i - 1]) {
			continue;
		}
    		for (int j = i + 1; j < nums.length; j++) {
			if (j != i + 1 && nums[j] == nums[j - 1]) {
				continue;
			}
			if (Math.abs(nums[i] - nums[j]) == k) {
				res++;
			}
		}
        }
	return res;
    }
}
