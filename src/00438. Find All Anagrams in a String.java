import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] scnt = new int[26];
        int[] pcnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pcnt[p.charAt(i)-'a']++;
            scnt[s.charAt(i)-'a']++;
        }
        for (int i = 0; i + p.length() <= s.length(); i++) {
            if (check(scnt, pcnt)) {
                ans.add(i);
            }
            if (i + p.length() == s.length()) {
                break;
            }
            scnt[s.charAt(i)-'a']--;
            scnt[s.charAt(i+p.length())-'a']++;
        }
        return ans;
    }
    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}