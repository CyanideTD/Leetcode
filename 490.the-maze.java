public class Solution {
    class Coordinate {
    	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
    }
    int[] directionX = {0, 0, -1, 1};
    int[] directionY = {1, -1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    	if (start[0] == destination[0] && start[1] == destination[1]) {
		return true;
	}
	int n = maze.length;
	int m = maze[0].length;
	boolean[][] visited = new boolean[n][m];
	Queue<Coordinate> queue = new LinkedList<>();
	Coordinate begin = new Coordinate(start[0], start[1]);
	Coordinate end = new Coordinate(destination[0], destination[1]);
	queue.offer(begin);
	while (!queue.isEmpty()) {
		Coordinate cur = queue.poll();
		if (cur.x == destination[0] && cur.y == destination[1]) {
			return true;
		}
		for (int i = 0; i < 4; i++) {
			Coordinate next = new Coordinate(cur.x, cur.y);
			while (valid(next, n, m) && maze[next.x][next.y] == 0) {
				next.x += directionX[i];
				next.y += directionY[i];
			}
				next.x = next.x - directionX[i];
				next.y = next.y - directionY[i];
				if (next.x == destination[0] && next.y == destination[1]) {
					return true;
				}
				if (visited[next.x][next.y]) {
					continue;
				} else {
					queue.add(next);
					visited[next.x][next.y] = true;
				}
			
		}
	}
	return false;
    }
    public boolean valid(Coordinate next, int n, int m) {
    	if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < m) {
		return true;
	} else {
		return false;
	}
    }
}
