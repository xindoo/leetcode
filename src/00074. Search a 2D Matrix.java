public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int x = matrix.length;
        int y = matrix[0].length;
        int i = 0, j = 0;
        while (i < x && matrix[i][j] <= target) {
            i++;
        }
        if (i > 0) i--;
        while (j < y) {
            if (j < y && matrix[i][j] == target)
                return true;
            j++;
        }
        return false;
    }
}