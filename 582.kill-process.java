public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    	List<Integer> res = new ArrayList<>();
	Queue<Integer> queue = new LinkedList<>();
	res.add(kill);
	queue.add(kill);
	int size = ppid.size();
	Map<Integer, List<Integer>> map = new HashMap<>();
	for (int i = 0; i < size; i++) {
		if (map.containsKey(ppid.get(i))) {
			map.get(ppid.get(i)).add(pid.get(i));
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(pid.get(i));
			map.put(ppid.get(i), list);
		}
	}
	while (!queue.isEmpty()) {
		int cur = queue.poll();
		if (map.containsKey(cur)) {
			for (int next : map.get(cur)) {
				queue.add(next);
				res.add(next);
			}
		}
	}
	return res;
    }
}
