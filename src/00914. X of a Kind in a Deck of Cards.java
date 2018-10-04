import java.util.HashMap;
import java.util.Map;

class Solution {
    int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        if(b % a == 0) {
            return a;
        }
        return gcd(Math.abs(a-b), Math.min(a, b));
    }
    
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : deck) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int tmp = -1;
        for(int val : map.values()) {
            if(tmp == -1) {
                tmp = val;
            } else  {
                tmp = gcd(tmp, val);
            }
            if(tmp < 2) {
                return false;
            }
        }
        return true;
    }
    
}