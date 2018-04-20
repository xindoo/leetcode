public class Solution {
    public static int integerBreak(int n) {
        int ans = 1;
        if (2 == n)
            return 1;
        if (3 == n)
            return 2;
        if (n%3 == 0) {
            for (int i =1; i <= n/3; i++)
                ans *= 3;
        }
        else if(n%3 == 1) {
            for (int i = 1; i < n/3; i++)
                ans *= 3;
            ans *= 4;
        }
        else {
            for (int i = 1; i <= n/3; i++)
                ans *= 3;
            ans *= 2;
        }
        return ans;

    }
}