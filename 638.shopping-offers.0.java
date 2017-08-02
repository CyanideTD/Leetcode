public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	Map<List<Integer>, Integer> map = new HashMap<>();
	return dfs(price, special, needs, map);	      
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
	if (map.containsKey(needs)) {
	    return map.get(needs);
	}
	int sum = Integer.MAX_VALUE;
	for (List<Integer> list : special) {
	    boolean flag = true;
	    List<Integer> next = new ArrayList<>();
	    for (int i = 0; i < needs.size(); i++) {
		int need = needs.get(i) - list.get(i);
		if (need < 0) {
		    flag = false;
		    break;
		} else {
		    next.add(need);
		}
	    }
	    if (flag) {
		sum = Math.min(sum, dfs(price, special, next, map) + list.get(list.size() - 1));
	    }
	}
	int nospecial = 0;
	for (int i = 0 ; i < needs.size(); i++) {
	    nospecial += needs.get(i) * price.get(i);
	}
	sum = Math.min(nospecial, sum);
	map.put(needs, sum);
	return sum;
    }
    
}
