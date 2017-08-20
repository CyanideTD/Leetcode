class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
	Arrays.sort(nums);
	int[] used = new int[nums.length];
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	dfs(res, path, nums, used); 
	return res;      
    }
    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int[] used) {
	if (path.size() == nums.length) {
	    res.add(new ArrayList<Integer>(path));
	    return;
	}
	
	for (int i = 0; i < nums.length; i++) {
	    if (used[i] == 0) {
		if (i == 0 || (nums[i] == nums[i - 1] && used[i - 1] == 1) || nums[i] != nums[i - 1]) {
		    path.add(nums[i]);
		    used[i] = 1;
		    dfs(res, path, nums, used);
		    path.remove(path.size() - 1);
		    used[i] = 0;
	        }
	    }
	}
    }
}
