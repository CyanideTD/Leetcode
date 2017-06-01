public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    	if (nums == null) {
		return 0;
	}
	if (nums.length < 2) {
		return nums.length;
	}
	int slow = 0;
	int max = 0;
	int fast = 0;
	int length = nums.length;
	while (slow < nums.length) {
		fast = slow;
		int index = length;
		int count = 0;
		boolean zero = false;
		while (fast < length) {
			if (nums[fast++] == 1) {
				count++;
			} else {
				if (zero) {
					break;
				} else {
					zero = true;
					index = fast - 1;
					count++;
				}
			}
		}
		max = Math.max(max, count);
		slow = index + 1;
	}
	return max;
    }
}
