public class Solution {
    public String intToRoman(int num) {
	Map<Character, String> map = new HashMap<>();
	StringBuilder res = new StringBuilder();
	int thousand = num / 1000;
	if (thousand != 0) {
	    if (thousand == 1) {
	    	res.append("M");
	    } else if (thousand == 2) {
	    	res.append("MM");
	    } else {
	    	res.append("MMM");
	    }
	}

	int hundred = (num / 100) % 10;
	if (hundred != 0) {
	    if (hundred == 1) {
	    	res.append("C");
	    } else if (hundred == 2) {
	    	res.append("CC");
	    } else if (hundred == 3) {
	    	res.append("CCC");
	    } else if (hundred == 4) {
	    	res.append("CD");
	    } else if (hundred == 5) {
	    	res.append("D");
	    } else if (hundred == 6) {
	    	res.append("DC");
	    } else if (hundred == 7) {
	    	res.append("DCC");
	    } else if (hundred == 8) {
	    	res.append("DCCC");
	    } else if (hundred == 9) {
	    	res.append("CM");
	    }
	}

	int ten = (num / 10) % 10;
	if (ten != 0) {
	    if (ten == 1) {
	    	res.append("X");
	    } else if (ten == 2) {
	    	res.append("XX");
	    } else if (ten == 3) {
	    	res.append("XXX");
	    } else if (ten == 4) {
	    	res.append("XL");
	    } else if (ten == 5) {
	    	res.append("L");
	    } else if (ten == 6) {
	    	res.append("LX");
	    } else if (ten == 7) {
	    	res.append("LXX");
	    } else if (ten == 8) {
	    	res.append("LXXX");
	    } else if (ten == 9) {
	    	res.append("XC");
	    }
	}

	int one = num % 10;
	if (one != 0) {
	    if (one == 1) {
	    	res.append("I");
	    } else if (one == 2) {
	    	res.append("II");
	    } else if (one == 3) {
	    	res.append("III");
	    } else if (one == 4) {
	    	res.append("IV");
	    } else if (one == 5) {
	    	res.append("V");
	    } else if(one == 6) {
	    	res.append("VI");
	    } else if (one == 7) {
	    	res.append("VII");
	    } else if (one == 8) {
	    	res.append("VIII");
	    } else if (one == 9) {
	    	res.append("IX");
	    }
	}

	return res.toString();
	
    }
}
