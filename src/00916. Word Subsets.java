import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxArrow = new int[26];
        for (String b : B) {
            int[] arrow = new int[26];
            for (char c : b.toCharArray()) {
                arrow[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxArrow[i] = Math.max(maxArrow[i], arrow[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String a : A) {
            int[] arrow = new int[26];
            for (char c : a.toCharArray()) {
                arrow[c-'a']++;
            }
            if (check(maxArrow, arrow)) {
                ans.add(a);
            }
        }
        return ans;
    }

    public boolean check(int[] maxArrow, int[] arrow) {
        for (int i = 0; i < 26; i++) {
            if (arrow[i] < maxArrow[i]) {
                return false;
            }
        }
        return true;
    }
}