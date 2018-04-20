public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (0 == row)
            return false;
        int col = matrix[0].length;
        int i = 0; 
        int j = col-1;
        while (i < row && j >= 0) {
            while (j >= 0 && matrix[i][j] >= target) {
                if (matrix[i][j] == target)
                    return true;
                if (j > 0)
                    j--;
                else 
                    break;
            }
            if (i < row-1)
                i++;
            else 
                break;
        }
        return false;
    }
}