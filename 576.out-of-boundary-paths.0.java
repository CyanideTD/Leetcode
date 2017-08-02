public class Solution {
    int MOD = 1000000007;
    int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int findPaths(int m, int n, int N, int i, int j) {
	Map<List<Integer>, Integer> map = new HashMap<>();
	List<Integer> start = new ArrayList<>();
	start.add(i);
	start.add(j);
	start.add(N);
	return dfs(m, n, start, map) % MOD;
    }
   
    public int dfs(int m, int n, List<Integer> point, Map<List<Integer>, Integer> map) {
	if (map.containsKey(point)) {
	    return map.get(point);
	}
	int i = point.get(0);
	int j = point.get(1);
	int N = point.get(2);
	if (i < 0 || i >= m || j < 0 || j >= n) {
	    return 1;
	}

	if (N == 0) {
	    return 0;
	}

	int sum = 0;	
	for (int[] dir : direction) {
	    int nexti = i + dir[0];
	    int nextj = j + dir[1];
	    List<Integer> nextP = new ArrayList<>();
	    nextP.add(nexti);
	    nextP.add(nextj);
	    nextP.add(N - 1);
	    sum = (sum +  dfs(m, n, nextP, map) % MOD) % MOD;
	}
	map.put(point, sum);
	return sum;
    }
    
}
