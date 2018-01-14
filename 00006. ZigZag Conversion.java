public class Solution {
    public String convert(String s, int numRows) {
        if (1 == numRows) 
            return s;
        int len = s.length();
        StringBuffer t = new StringBuffer();
        int[] a = {2*(numRows-1), 0};
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            int index = 0;
            while (pos < len) {
                if (0 != a[index]) {
                    t.append(s.charAt(pos));
                    pos += a[index];
                }
                index = index^1;
            }
            a[0] -= 2;
            a[1] += 2;
        }
        return new String(t);
    }
}