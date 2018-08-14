class Solution {
    private int mergeSort(int[] nums, int l, int r) {
        if (r-l < 1) {
            return 0;
        }
        int mid = (l+r)>>1;
        int res = mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r);
        int[] sorted = new int[r-l+1];
        int cnt = 0;
        int li = l;
        int ri =  mid+1;
        while (ri <= r) {
            cnt += mid - li + 1;
            while (li <= mid && (long)nums[li] <= (long)nums[ri]*2L) {
                li++;
                cnt--;
            }
            ri++;
        }
        res += cnt;
        li = l;
        ri = mid+1;
        int pos = 0;
        while (li <= mid && ri <= r) {
            if (nums[li] <= nums[ri]) {
                sorted[pos++] = nums[li++];
            } else {
                sorted[pos++] = nums[ri++];
            }
        }
        while (li <= mid) {
            sorted[pos++] = nums[li++];
        }
        while (ri <= r) {
            sorted[pos++] = nums[ri++];
        }
        for (int i = l; i <= r; i++) {
            nums[i] = sorted[i-l];
        }
        return res;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}