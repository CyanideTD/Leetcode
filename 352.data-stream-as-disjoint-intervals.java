/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    List<Interval> intervals;
    /** Initialize your data structure here. */
    public SummaryRanges() {
    	intervals = new ArrayList<>();
    }
    
    public void addNum(int val) {
        boolean flag = false;
	int index = -1;;
	for (int i = 0; i < intervals.size(); i++) {
		if (val <= intervals.get(i).end && val >= intervals.get(i).start) {
			return;
		} else if (intervals.get(i).end + 1 == val) {
			intervals.get(i).end++;
			index = i;
			flag = true;
			break;
		} else if (intervals.get(i).start - 1 == val) {
			intervals.get(i).start--;
			index = i;
			flag = true;
			break;
		}
	}
	if (flag) {
		for (int i = 0; i < intervals.size(); i++) {
			if (index == i) {
				continue;
			}
			if (intervals.get(i).end + 1 == intervals.get(index).start) {
				intervals.get(i).end = intervals.get(index).end;
				intervals.remove(index);
			} else if (intervals.get(i).start - 1 == intervals.get(index).end) {
				intervals.get(i).start = intervals.get(index).start;
				intervals.remove(index);
			}
		}
	} else {
		Interval inter = new Interval(val, val);
		intervals.add(inter);
	}

    }
    
    public List<Interval> getIntervals() {
	intervals.sort((Interval o1, Interval o2) -> o1.start - o2.start);
        return intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
