public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] chr1 = new char[256];
        char[] chr2 = new char[256];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (chr1[s.charAt(i)-0] != 0 && chr1[s.charAt(i)-0] != t.charAt(i))
                return false;
            else
                chr1[s.charAt(i)-0] = t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (chr2[t.charAt(i)-0] != 0 && chr2[t.charAt(i)-0] != s.charAt(i))
                return false;
            else
                chr2[t.charAt(i)-0] = s.charAt(i);
        }
        return true;
    }
}