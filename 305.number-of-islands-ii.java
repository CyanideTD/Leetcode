public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	List<Integer> res = new ArrayList<>();
        int count = 0;
	int[][] grid = new int[m][n];
	int[] directionX = {0, 0, -1, 1};
	int[] directionY = {1, -1, 0, 0};
	int[] id = new int[n * m];
	for (int i = 0; i < n * m; i++) {
		id[i] = i;
	}
	for (int[] pos : positions) {
		count++;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			grid[pos[0]][pos[1]] = 1;
			int x = pos[0] + directionX[i];
			int y = pos[1] + directionY[i];
			if (x >= 0 && x < m && y >= 0 && y < n) {
				if (grid[x][y] == 1) {
					union(id, x, y, pos[0], pos[1], n);
					if (set.add(find(id, x, y, n))) {
						count--;
					}
				}
			}
		}
		res.add(count);
	}
	return res;
    }
    public void union(int[] id, int i, int j, int x, int y, int m) {
    	int parent = find(id, i, j, m);
	int child = find(id, x, y, m);
	if (parent == child) {
		return;
	}
	id[child] = parent;
    }
    public int find(int[] id, int i, int j, int m) {
    	int index = i * m + j;
	while (index != id[index]) {
		id[index] = id[id[index]];
		index = id[index];
	}
	return index;
    }
}
