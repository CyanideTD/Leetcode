public class Solution {
    public int countComponents(int n, int[][] edges) {
    	int[] lable = new int[n];
	for (int i = 0; i < n; i++) {
		lable[i] = i;
	}
	for (int[] edge : edges) {
		union(lable, edge[0], edge[1]);
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
		if (lable[i] == i) {
			count++;
		}
	}
	return count;
    }
    public void union(int[] lable, int i, int j) {
    	int parent = find(lable, i);
	int child = find(lable, j);
	if (parent == child) {
		return;
	}
	lable[child] = parent;
    }
    public int find(int[] lable, int index) {
    	while (index != lable[index]) {
		lable[index] = lable[lable[index]];
		index = lable[index];
	}
	return index;
    }
}
