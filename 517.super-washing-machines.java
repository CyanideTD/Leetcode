public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
	for (int i = 0; i < machines.length; i++) {
	    sum += machines[i];
	}
	if (sum % machines.length != 0) {
	    return -1;
	}
	int avg = sum / machines.length;
	int[] sums = new int[machines.length];
	int minimum = 0;
	for (int i = 0; i < machines.length; i++) {
	    if (i == 0) {
		sums[i] = machines[i];
		minimum = Math.max(minimum, Math.abs(avg - machines[i]));
	    } else {
		sums[i] = sums[i - 1] + machines[i];
		int left = sums[i - 1] - avg * i;
		int right = (sum - sums[i]) - (machines.length - i - 1) * avg;
		if (left < 0 && right > 0 || left > 0 && right < 0) {
		    int temp  = Math.max(Math.abs(left), Math.abs(right));
		    minimum = Math.max(minimum, temp);
		} else if (left > 0 && right > 0) {
		    int temp = Math.max(left, right);
		    minimum = Math.max(minimum, temp);
		} else if (left < 0 && right < 0) {
		    minimum = Math.max(Math.abs(left) + Math.abs(right), minimum);
		} else if (left == 0 || right == 0) {
		    int temp = Math.max(Math.abs(left), Math.abs(right));
		    minimum = Math.max(temp, minimum);
		}
	    }
	}
	return minimum;
    }
}
