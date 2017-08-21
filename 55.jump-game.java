class Solution {
    public boolean canJump(int[] nums) {
	int reach = 0;
	for (int i = 0; i <= reach && i < nums.length; i++) {
	    reach = Math.max(i + nums[i], reach);
	}
	return reach >= nums.length - 1;
    }
}
