public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        final char[] sc = s.toCharArray();
        int lsi = sc.length/2 + sc.length%2;
        int lei = lsi; //longest start index, longest end index (both inclusives)
        int longestLength = lei - lsi + 1;
        int[][] mults = {{-1,0},{-1,1},{1,0},{1,1}};

        for(int i = 0 ; i <= sc.length/2 - longestLength / 2  ; i++) {
            for(int[] m : mults) {
                int si = sc.length / 2 + i * m[0];
                int ei = si + m[0] * m[1];
                if(si > ei) {
                    int t = si;
                    si = ei;
                    ei = t;
                }
                if(si >= 0 && ei < sc.length && sc[si] != sc[ei]) continue;
                while (si > 0 && ei < sc.length - 1 && sc[si-1] == sc[ei+1]) {
                    si--;
                    ei++;
                }
                if(ei-si+1 > longestLength) {
                    lsi = si;
                    lei = ei;
                    longestLength = lei - lsi + 1;
                }
            }
        }

        return s.substring(lsi, lei+1);
    }
}