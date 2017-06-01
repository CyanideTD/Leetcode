public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
		return new int[0];
	}
	int i = 0;
	int j = 0;
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	int length1 = nums1.length;
	int length2 = nums2.length;
	List<Integer> list = new ArrayList<>();
	while (i < length1 && j < length2) {
		if (nums1[i] > nums2[j]) {
			j++;
		} else if (nums1[i] < nums2[j]) {
			i++;
		} else {
			list.add(nums1[i]);
			i++;
			j++;
		}
	}
	int[] res = new int[list.size()];
	for (int k = 0; k < res.length; k++) {
		res[k] = list.get(k);
	}
	return res;
    }
}
