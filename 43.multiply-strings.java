public class Solution {
    public String multiply(String num1, String num2) {
	if (num1.equals("0") || num2.equals("0")) {
	    return "0";
	}
	int[] result = new int[num1.length() + num2.length()];
	if (num1.length() > num2.length()) {
	    String temp = num1;
	    num1 = num2;
	    num2 = temp;
	}
	int n1 = num1.length();
	int n2 = num2.length();
	for (int i = n1 - 1; i >= 0; i--) {
	    for (int j = n2 - 1; j >= 0; j--) {
		int a = num1.charAt(i) - '0';
	  	int b = num2.charAt(j) - '0';
		int mul = a * b;
		result[i + j + 1] += mul;
	    }
	}
	int carry = 0;
	for (int i = n1 + n2 - 1; i >= 0; i--) {
	    result[i] += carry;
	    carry = result[i] / 10;
	    result[i] = result[i] % 10;
	}
	StringBuilder sb = new StringBuilder();
	for (int num : result) {
	    sb.append(num);
	}
	while (sb.charAt(0) == '0') {
	    sb.deleteCharAt(0);
	}
	return sb.toString();
    }
}
