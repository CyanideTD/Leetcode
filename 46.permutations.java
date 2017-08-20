class Solution {
    public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	Set<Integer> set = new HashSet<>();
	dfs(res, path, nums, set);   
	return res;     
    }
    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, Set<Integer> set) {
	if (path.size() == nums.length) {
	    res.add(new ArrayList<Integer>(path));
	    return;
	}	
	
	for (int i = 0; i < nums.length; i++) {
	    if (!set.contains(nums[i])) {
		path.add(nums[i]);
		set.add(nums[i]);
		dfs(res, path, nums, set);
		path.remove(path.size() - 1);
		set.remove(nums[i]);
	    }
	}
    }
}
