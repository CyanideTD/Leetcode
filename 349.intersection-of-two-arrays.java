public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
		return new int[0];
	}
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	Set<Integer> set = new HashSet<>();
	int i = 0;
	int j = 0;
	int length1 = nums1.length;
	int length2 = nums2.length;
	while (i < length1 && j < length2) {
		if (nums1[i] < nums2[j]) {
			int num = nums1[i];
			while (i < length1) {
				if (nums1[i] != num) {
					break;
				}
				i++;
			}
		} else if (nums1[i] == nums2[j]) {
			set.add(nums1[i]);
			i++;
			j++;
		} else {
			int num = nums2[j];
			while (j < length2) {
				if (nums2[j] != num) {
					break;
				}
				j++;
			}
		}
	}
	int[] res = new int[set.size()];
	int k = 0;
	for (int num : set) {
		res[k++] = num;
	}
	return res;
    }
}
