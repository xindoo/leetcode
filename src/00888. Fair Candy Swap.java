import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int suma = 0;
        for (int i = 0; i < A.length; i++) {
            suma += A[i];
        }
        int sumb = 0;
        for (int i = 0; i < B.length; i++) {
            sumb += B[i];
        }

        int sum = (suma + sumb) /2;
        int rA = sum - suma;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            set.add(B[i]);
        }
        int[] ans = new int[2];
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i]+rA)) {
                ans[0] = A[i];
                ans[1] = A[i]+rA;
            }
        }
        return ans;
    }
}