public class Solution {
    public int longestConsecutive(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	for (int num : nums) {
		set.add(num);
	}
	Map<Integer, List<Integer>> map = new HashMap<>();
	for (int num : set) {
		if (map.containsKey(num)) {
			if (set.contains(num - 1)) {
				map.get(num).add (num - 1);
			}
			if (set).contains(num + 1) {
				map.get(num).add(num + 1);
			}
		} else {
			map.put(num, new ArrayList<>());
			if (set.contains(num - 1)) {
				map.get(num).add(num - 1);
			}
			if (set.contains(num + 1)) {
				map.get(num).add(num - 1);
			}
		}
		
	}

    }
}
