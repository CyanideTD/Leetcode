public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	Set<String> dict = new HashSet<>();
	for (String word : wordList) {
		dict.add(word);
	}
	if (!dict.contains(endWord)) {
		return 0;
	}
	Set<String> start = new HashSet<>();
	Set<String> end = new HashSet<>();
	start.add(beginWord);
	end.add(endWord);
	dict.remove(endWord);
	dict.remove(beginWord);
	int count = 0;
	while (!start.isEmpty() && !end.isEmpty()) {
		count++;
		Set<String> next = new HashSet<>();
		if (start.size() > end.size()) {
			Set<String> temp = start;
			start = end;
			end = temp;
		}
		for (String word : start) {
			for (int i = 0; i < word.length(); i++) {
				char[] string = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					string[i] = j;
					String nextWord = String.valueOf(string);
					if (end.contains(nextWord)) {
						return count + 1;
					}
					if (dict.contains(nextWord)) {
						next.add(nextWord);
						dict.remove(nextWord);
					}
				}
			}
		}
		start = next;
	}
	return 0;
    }
}
