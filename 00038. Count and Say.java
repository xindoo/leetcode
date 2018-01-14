class Solution {
    public String countAndSay(int n) {
        if (1 == n || 0 == n) {
            return "1";
        }
        String last = countAndSay(n-1);
        String res = "";
        int cnt = 0;
        char c = last.charAt(0);
        for (int i = 0; i < last.length(); i++) {
            if (c == last.charAt(i)) {
                cnt++;
            } else {
                res = res + cnt + last.charAt(i-1);
                cnt = 1;
                c = last.charAt(i);
            }
        }
        res = res + cnt + c;
        return res;
    }
}