public class Solution {
    public int longestConsecutive(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
	int max = 0;
	for (int num : nums) {
		if (map.containsKey(num)) {
			continue;	
		} else {
			int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
			int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
			int sum = left + right + 1;
			max = Math.max(max, sum);
			map.put(num, 1);
			map.put(num - left, sum);
			map.put(num + right, sum);
		}
	}
	return max;
    }
}
