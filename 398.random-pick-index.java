public class Solution {
    int[] arr;
    public Solution(int[] nums) {
        arr = nums;
    }
    
    public int pick(int target) {
        Random r = new Random();
	int num = 0;
	int index = 0;
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == target) {
		num++;
		int rand = r.nextInt(num);
		if (rand == 0) {
		    index = i;
	 	}
	    }
	}
	return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
