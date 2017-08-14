public class Solution {
    public int divide(int dividend, int divisor) {
	if (dividend == Integer.MIN_VALUE && divisor == -1) {
	    return Integer.MAX_VALUE;
	}
	int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
	long dend = Math.abs((long)dividend);
	long visor = Math.abs((long)divisor);
	int res = 0;
	while (dend >= visor) {
	    int mul = 1;
	    long div = visor;
	    while (dend >= (div << 1)) {
		div <<= 1;
		mul <<= 1;
	    }
	    dend = dend - div;
	    res += mul;
	}
	return res * sign;
    }
}
