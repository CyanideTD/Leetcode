public class Solution {
    public boolean validTree(int n, int[][] edges) {
    	int[] lable = new int[n];
	for (int i = 0; i < n; i++) {
		lable[i] = i;
	}	
	for (int[] edge : edges) {
		if (!union(lable, edge[0], edge[1])) {
			return false;
		}
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
		if (lable[i] == i) {
			count++;
		}
	}
	if (count >1) {
		return false;
	}
	return true;
    }
    public boolean union(int[] lable, int i, int j) {
    	int parent = find(lable, i);
	int child = find(lable, j);
	if (parent == child) {
		return false;
	}
	lable[child] = parent;
	return true;
    }
    public int find(int[] lable, int index) {
    	while (index != lable[index]) {
		lable[index] = lable[lable[index]];
		index = lable[index];
	}
	return index;
    }
}
