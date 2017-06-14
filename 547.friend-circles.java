public class Solution {
    public int findCircleNum(int[][] M) {
    	int n = M.length;
	int[] id = new int[n];
    	for (int i = 0; i < n; i++) {
		id[i] = i;
	}
	for (int i = 0 ; i< n; i++) {
		for (int j = i; j < n; j++) {
			if (M[i][j] == 1) {
				union(id, i, j);
			}
		}
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
		if(id[i] == i) {
			count++;
		}
	}
	return count;
    }
    public void union(int[] id, int i, int j) {
    	int parent = find(id, i);
	int child = find(id, j);
	if (parent == child) {
		return;
	}
	id[child] = parent;
    }
    public int find(int[] id, int i) {
    	while (i != id[i]) {
		id[i] = id[id[i]];
		i = id[i];
	}
	return i;
    }
}
