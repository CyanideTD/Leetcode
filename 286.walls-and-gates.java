public class Solution {
    class Coordinate {
    	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
    }
    public void wallsAndGates(int[][] rooms) {
	if (rooms == null || rooms.length == 0) {
		return;
	}
    	int n = rooms.length;
	int m = rooms[0].length;
	int[] directionX = {0, 0, -1, 1};
	int[] directionY = {1, -1, 0, 0};
	Set<Coordinate> set = new HashSet<>();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (rooms[i][j] == 0) {
				set.add(new Coordinate(i, j));
			}
		}
	}
	int path = 0;
	while (!set.isEmpty()) {
		path++;
		Set<Coordinate> nextLevel = new HashSet<>();
		for (Coordinate coor : set) {
			for (int i = 0; i < 4; i++) {
				Coordinate next = new Coordinate(coor.x + directionX[i], coor.y + directionY[i]);
				if (valid(next, n, m)) {
					if (rooms[next.x][next.y] == Integer.MAX_VALUE) {
						rooms[next.x][next.y] = path;
						nextLevel.add(next);
					}
				}
			}
		}
		set = nextLevel;
	}
    }
    public boolean valid(Coordinate coor, int n, int m) {
    	if (coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m) {
		return true;
	}
	return false;
    }
}
