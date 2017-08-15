public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	Arrays.sort(candidates);
	List<List<Integer>> res = new ArrayList<>();
	if (candidates == null || candidates.length == 0) {
	    return res;
	}
	List<Integer> list = new ArrayList<>();
	dfs(candidates, 0, target, res, list);
	return res;
    }

    public void dfs(int[] candidates, int index, int remain, List<List<Integer>> res, List<Integer> path) {
	if (remain == 0) {
	    res.add(new ArrayList<Integer>(path));
	}
	for (int i = index; i < candidates.length; i++) {
	    if (remain < candidates[i]) {
		break;
	    } else {
		path.add(candidates[i]);
		dfs(candidates, i, remain - candidates[i], res, path);
		path.remove(path.size() - 1);
	    }
	}
    }
} 
