/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
	this.val = val;	
    }	
}
public class SummaryRanges {
    TreeNode root;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        root = null;
    }
    
    public void addNum(int val) {
        root = insert(root, val);
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
	preorder(root, res);
	return res;
    }

    public void preorder(TreeNode root, List<Interval> res) {
	if (root == null) {
	    return;
	}
	preorder(root.left, res);
	if (res.size() == 0) {
	    Interval interval = new Interval(root.val, root.val);
	    res.add(interval);
	} else if (res.get(res.size() - 1).end + 1 == root.val) {
	    res.get(res.size() - 1).end += 1;
	} else {
	    Interval interval = new Interval(root.val, root.val);
	    res.add(interval);
	}
	preorder(root.right, res);
    }
    
    public TreeNode insert(TreeNode root, int val) {
	if (root == null) {
	    root = new TreeNode(val);
	} else if (root.val > val) {
	    root.left = insert(root.left, val);
	} else if (root.val < val) {
	    root.right = insert(root.right, val);
	}
	return root;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
