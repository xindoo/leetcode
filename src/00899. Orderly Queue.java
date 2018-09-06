import java.util.Arrays;

class Solution {
    public String orderlyQueue(String S, int K) {
        if(K == 1) 
            return slideString(S);
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public String slideString(String S) {
        String res = S, cur = S;
        for(int i = 0; i < S.length(); i++) {
            cur = cur.substring(1) + cur.charAt(0);
            if(cur.compareTo(res) < 0)
                res = cur;
        }
        return res;
    }
}