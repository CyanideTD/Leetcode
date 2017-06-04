public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    	List<Integer> res = new ArrayList<>();
	Queue<Integer> queue = new LinkedList<>();
	res.add(kill);
	queue.add(kill);
	int size = ppid.size();
	while (!queue.isEmpty()) {
		int cur = queue.poll();
		for (int i = 0; i < size; i++) {
			if (ppid.get(i) == cur) {
				queue.add(pid.get(i));
				res.add(pid.get(i));
			}
		}
	}
	return res;
    }
}
