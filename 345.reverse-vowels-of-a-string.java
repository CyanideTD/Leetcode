public class Solution {
    public String reverseVowels(String s) {
    	if (s == null || s.length() < 2) {
		return s;
	}
	char[] string = s.toCharArray();
	int i = 0;
	int j = s.length() - 1;
	while (i < j) {
		while (i < j && !isVowel(string, i)) {
			i++;
		}
		while (j > i && !isVowel(string, j)) {
			j--;
		}
		char temp = string[i];
		string[i] = string[j];
		string[j] = temp;
		i++;
		j--;
	}
	return String.valueOf(string);
    }
    public boolean isVowel(char[] string, int i) {
    	if (string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u'|| string[i] ==  'A' || string[i] == 'E' || string[i] == 'I' || string[i] == 'O' || string[i] == 'U') {
		return true;
	}
	return false;
    }
}
