public class Solution {
    public int candy(int[] ratings) {
	if (ratings == null || ratings.length == 0) {
		return -1;
	}    
	int prev = 1;
	int down = 0;
	int sum = 1;
	for (int i = 1; i < ratings.length; i++) {
		if (ratings[i] < ratings[i - 1]) {
			down++;
		} else {
			if (down > 0) {
				sum += down * (down + 1) / 2;
				if (down >= prev) {
					sum += down - prev + 1;
				}
				prev = 1;
				down = 0;
			}
			prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
			sum += prev;
		}
	}
	if (down > 0) {
		sum += down * (down + 1) / 2;
		if (down >= prev) {
			sum += down - prev + 1;
		}
	}
	return sum;
    }
}
