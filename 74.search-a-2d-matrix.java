public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	    return false;
	}
	int n = matrix.length;
	int m = matrix[0].length;
	int lo = 0;
	int hi = n * m - 1;
	while (lo + 1 < hi) {
	    int mid = (lo + hi) >>> 1;
	    int row = mid / m;
	    int col = mid % m;
	    if (matrix[row][col] == target) {
	    	return true;
	    } else if (matrix[row][col] > target) {
	    	hi = mid;
	    } else {
	    	lo = mid;
	    }
	}
	if (matrix[lo / m][lo % m] == target) {
	    return true;
	}
	if (matrix[hi / m][hi % m] == target) {
	    return true;
	}
	return false;
    }
}
