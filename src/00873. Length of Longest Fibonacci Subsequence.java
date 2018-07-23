import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int[] dp = new int[A.length+1];
        Set<Integer> set = new HashSet<>();
        for (int i = A.length-1; i >= 0; i--) {
            set.add(A[i]);
        }
        int maxlen = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int a = A[j], b = A[i];
                int len = 2;
                while (set.contains(a+b)) {
                    int c = a+b;
                    a = b;
                    b = c;
                    len++;
                    maxlen = Math.max(maxlen, len);
                }
            }
        }
        return maxlen;
    }
}