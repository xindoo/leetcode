public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>nums1Set = new HashSet<Integer>();
        HashSet<Integer>nums2Set = new HashSet<Integer>();
        HashSet<Integer>resSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            nums2Set.add(nums2[i]);
        }
        Iterator<Integer> iter = nums1Set.iterator();
        while (iter.hasNext()){
            Integer next = iter.next();
            if (nums2Set.contains(next)){
                resSet.add(next);
            }
        }
        int[]res = new int[resSet.size()];
        Iterator<Integer>resIterator = resSet.iterator();
        int index = 0;
        while(resIterator.hasNext()){
            res[index] = resIterator.next();
            index++;
        }
        return res;
    }
}