class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0)
            return false;

        for (int i = 0; i < matrix[0].length; i++) {
            int v = matrix[0][i];
            for (int j = 0; j < matrix.length && j + i < matrix[0].length; j++) {
                if (matrix[j][i+j] != v) {
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int v = matrix[i][0];
            for (int j = 0; j < matrix[0].length && j + i < matrix.length; j++) {
                if (matrix[i+j][j] != v) {
                    return false;
                }
            }
        }
        return true;
    }
}