class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] a, int[] b) -> a[0] - b[0]);
        int tail = Integer.MIN_VALUE, len = 0;
        for (int[] pair : pairs) {
            if (pair[1] < tail) {
                tail = pair[1];
            }
            if (pair[0] > tail) { 
                len++; 
                tail = pair[1]; 
            }
        }
        return len;
    }
}