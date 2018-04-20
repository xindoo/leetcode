public class Solution {
    public void rotate(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ans[i][j]= matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length-i-1] = ans[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,2,3}, {4, 5, 6}, {7,8,9}};
        s.rotate(a);
    }
}