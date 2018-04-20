import java.util.Arrays;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
       // Arrays.sort(A);
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            int sub = A[i] - A[i-1];
            int j = i;
            int slicescnt = 1;
            while (j < A.length && A[j] -A[j-1] == sub) {
                slicescnt++;
                j++;
            }
            if (slicescnt >= 3)
                ans = ans + slicescnt - 2;
        }
        return ans;
    }
}