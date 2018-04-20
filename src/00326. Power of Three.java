public class Solution {
    public boolean isPowerOfThree(int n) {
        if (0 ==n)
            return false;
        while (n%3 == 0) {
            n = n/3;
        }
        if (1 == n)
            return true;
        else 
            return false;
    }
}