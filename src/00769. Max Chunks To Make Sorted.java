class Solution {
    public int maxChunksToSorted(int[] arr) {
        int cnt = 0;
        int maxP = 0;
        for (int i = 0; i < arr.length; i++) {
            maxP = Math.max(maxP, arr[i]);
            if (maxP == i) {
                cnt++;
            }
        }
        return cnt;
    }
}