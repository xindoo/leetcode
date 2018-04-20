import java.util.Scanner;

public class Solution {
    private long bsearch(long n, int d) {
        long left = 1;
        long right = (long)(Math.pow((double)n, 1.0/d) + 1);
        while (left < right) {
            long mid = (left+right)>>1;
            long sum = 0, cur = 1;
            for (int i = 0; i <= d;i++) {
                sum += cur;
                cur *= mid;
            }
            if (sum == n)
                return mid;
            if (sum>n)
                right=mid-1;
            else
                left=mid+1;
        }
        return 0;
    }
    public String smallestGoodBase(String n) {
        long num = 0;
        for (char c : n.toCharArray()) num = num * 10 + c - '0';
        long x = 1;
        for (int i = 63; i > 0; i--) {
            if ((x<<i) < num) {
                long res = bsearch(num, i);
                if (0 != res)
                    return String.valueOf(res);
            }
        }
        return String.valueOf(num-1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestGoodBase("219661"));
    }
}