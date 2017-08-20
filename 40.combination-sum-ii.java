public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	if (candidates == null || candidates.length == 0) {
	    return new ArrayList<List<Integer>>();
	}
	Arrays.sort(candidates);
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	dfs(res, path, 0, target, candidates);
	return res;        
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int index, int remain, int[] candidates) {
	if (remain == 0) {
	    res.add(new ArrayList<Integer>(path));
	    return;
	}	
	for (int i = index; i < candidates.length; i++) {
	    if (candidates[i] > remain) {
		break;
	    } else {
		if (i != index && candidates[i] == candidates[i - 1]) {
		    continue;
		} else {
		    path.add(candidates[i]);
		    dfs(res, path, i + 1, remain - candidates[i], candidates);
		    path.remove(path.size() - 1);
		}
	    }
	}
    }
}
