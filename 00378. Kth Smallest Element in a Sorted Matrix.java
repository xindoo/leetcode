class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] pos= new int[matrix.length];
        int res = 0;
        for (int i = 0; i < k; i++) {
            int minvalue = Integer.MAX_VALUE;
            int minpos = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (pos[j] >= matrix[0].length){
                    continue;
                }
                if (matrix[j][pos[j]] < minvalue) {
                    minvalue = matrix[j][pos[j]];
                    minpos = j;
                }
            }
            res = minvalue;
            pos[minpos]+=1;
        }
        return res;
    }
}