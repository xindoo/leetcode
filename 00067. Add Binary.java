public class Solution {
    public String addBinary(String a, String b) {
        int[] count = new int[10000];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int cnt = 0;
        int add = 0;
        while (i >= 0 && j >= 0) {
            int x = 0, y = 0;
            if (a.charAt(i--) == '1')
                x = 1;
            if (b.charAt(j--) == '1')
                y = 1;
            count[cnt++] = (x+y+add)%2;
            add = (x+y+add)/2;
        }
        while (i >= 0) {
            int x = 0;
            if (a.charAt(i--) == '1')
                x = 1;
            count[cnt++] = (x+add)%2;
            add = (x+add)/2;
        }
        while (j >= 0) {
            int y = 0;
            if (b.charAt(j--) == '1')
                y = 1;
            count[cnt++] = (y+add)%2;
            add = (y+add)/2;
        }
        if (1 == add) {
            count[cnt++] = 1;
        }
        String ans = "";
        while (--cnt >= 0) {
            if (1 == count[cnt])
                ans += "1";
            else 
                ans += "0";
        }
        return ans;
    }
}