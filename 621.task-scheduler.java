class Node {
    char c;
    int num;
    Node(char c, int num) {
	this.c = c;
	this.num = num;	
    }
}
public class Solution {
    public int leastInterval(char[] tasks, int n) {
	int num = 0;
	int sum = 0;
	Map<Character, Integer> map = new HashMap<>();
	Deque<Node> queue = new ArrayDeque<>();
	for (char c : tasks) {
	    if (map.containsKey(c)) {
		map.put(c, map.get(c) + 1);
	    } else {
		map.put(c, 1);
	    }
	    num++;
	}
	
	PriorityQueue<Node> pq = new PriorityQueue<>(100, (a, b) -> b.num - a.num);
	for (char c : map.keySet()) {
	    pq.offer(new Node(c, map.get(c)));
	}
	while (num > 0) {
	    if (pq.isEmpty()) {
		Node idle = new Node('#', 0);
	  	queue.add(idle);
	    } else {
		Node cur = pq.poll();
		cur.num -= 1;
		if (cur.num != 0) {
	 	    queue.add(cur);
		} else {
		    queue.add(new Node('#', 0));
		}
		num--;
	    }
	    if (queue.size() > n) {
		    Node pop = queue.poll();
		    if (pop.c != '#') {
			pq.add(pop);
		    }
	    }
	    sum++;
	}
	return sum;
    }
}
