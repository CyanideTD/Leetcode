class Solution {
    public double myPow(double x, int n) {
	double div = n;
	if (div == 0) {
	    return 1;
	}
	if (div < 0) {
	    x = 1 / x;
	    div = -div;
	}

	double res = x;
	double carry = 1;
	while (div > 1) {
	    if (div % 2 == 0) {
		res *= res;
		div = div / 2;
	    } else {
		carry *= res;
		res *= res;
		div = (div - 1) / 2;
	    }
	}
	res = res * carry;
	return res;
    }
}
