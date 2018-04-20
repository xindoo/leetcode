public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        long start = 1;
        long end = num;
        while (start + 1 < end) {
            long mid = (end - start) / 2 + start;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == num || end * end == num) {
            return true;
        } else {
            return false;
        }
    }
}