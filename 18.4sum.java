public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>> res = new ArrayList<>();
	if (nums == null || nums.length < 4) {
	    return res;
	}
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
	    int target3 = target - nums[i];
	    for (int j = i + 1; j < nums.length; j++) {
		int target2 = target3 - nums[j];
		int front = j + 1;
		int end = nums.length - 1;
	  	while (front < end) {
		    if (nums[front] + nums[end] > target2) {
			end--;
		    } else if (nums[front] + nums[end] < target2) {
			front++;
		    } else {
			List<Integer> list = new ArrayList<>();
			list.add(nums[i]);
			list.add(nums[j]);
			list.add(nums[front]);
			list.add(nums[end]);
			res.add(list);
			while (front < end && nums[end] == list.get(3)) {
	 		    end--;
			}
			while (front < end && nums[front] == list.get(2)) {
			    front++;
			}
		    }
		}
		while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
		    j++;
		}
	    }
	    while (i + 1< nums.length && nums[i] == nums[i + 1]) {
		i++;
	    }
	}
	return res;
    }
}
