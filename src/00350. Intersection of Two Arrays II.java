public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > 0)
            Arrays.sort(nums1);
        if (nums2.length > 0)
            Arrays.sort(nums2);
       // List<int> list = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}