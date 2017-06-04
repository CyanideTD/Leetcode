public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
    	if (nums == null || nums.length < 3) {
		return 0;
	}
	int length = nums.length;
	int first = 0;
	int second = 1;
	int last = length - 1;
	int count = 0;
	Arrays.sort(nums);
	while (first < length - 2) {
		second = first + 1;
		last = length - 1;
		while (second < last) {
			if (nums[first] + nums[second] + nums[last] < target) {
				count += last - second;
				second++;
			} else {
				last--;
			}
		}
		first++;
	}
	return count;
    }
}
