public class Solution {
    public int countArrangement(int N) {
	int[] hm = new int[N + 1];
	return dfs(N, hm, 1);        
    }
    public int dfs(int N, int[] hm, int index) {
	if (index > N) {
	    return 1;
	}
	int result = 0;
	int[] next = Arrays.copyOf(hm, N + 1);
	for (int i = 1; i <= N; i++) {
	    if (hm[i] == 0) {
		if (i % index == 0 || index % i == 0) {
		    next[i] = 1;
		    result += dfs(N, next, index + 1);
		    next[i] = 0;
	  	}
	    }
	}
	return result;
    }
}
