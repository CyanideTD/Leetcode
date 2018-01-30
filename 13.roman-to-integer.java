class Solution {
    public int romanToInt(String s) {
	if (s == null) {
	    return 0;
	}
	char[] str = s.toCharArray();
	int res = 0;
	for (int i = 0; i < str.length; i++) {
	    if (str[i] == 'I') {
	    	res += 1;
	    } else if (str[i] == 'V') {
	    	res += 5;
		if (i != 0 && str[i - 1] == 'I') {
		    res -= 2;
		}
	    } else if (str[i] == 'X') {
	    	res += 10;
		if (i != 0 && str[i - 1] == 'I') {
		    res -= 2;
		}
	    } else if (str[i] == 'L') {
	    	res += 50;
		if (i != 0 && str[i - 1] == 'X') {
			res -= 20;
		}
	    } else if (str[i] == 'C') {
	    	res += 100;
		if (i != 0 && str[i - 1] == 'X') {
		    res -= 20;
		}
	    } else if (str[i] == 'D') {
	    	res += 500;
		if (i != 0 && str[i - 1] == 'C') {
		    res -= 200;
		}
	    } else if (str[i] == 'M') {
	    	res += 1000;
		if (i != 0 && str[i - 1] == 'C') {
		   res -= 200;
		}
	    }
	}
	return res;
    }
}
