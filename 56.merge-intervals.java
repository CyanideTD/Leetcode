/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
	Collections.sort(intervals, (a, b) -> a.start - b.start);
	int index = 0;
	while (index < intervals.size() - 1) {
	    int next = index + 1;
	    if (intervals.get(next).start <= intervals.get(index).end) {
		intervals.get(index).end = Math.max(intervals.get(next).end, intervals.get(index).end);
		intervals.remove(next);
		continue;
	    }
	    index++;
	}
	return intervals;
    }
}
