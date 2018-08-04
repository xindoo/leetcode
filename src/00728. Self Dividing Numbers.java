import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = left; i <= right; i++) {
            if (judge(i))
                ans.add(i);
        }
        return ans;
    }
    
    public boolean judge(int n) {
        int tmp = n;
        while (n > 0) {
            int r = n % 10;
            if (r == 0) {
                return false;
            }
            if (tmp % r != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

}