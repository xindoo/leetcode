import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int sum = 0;
        while (n != 0) {
            int m = n%10;
            sum += m*m;
            n/=10;
        }
        return isHappy(sum);
    }
}