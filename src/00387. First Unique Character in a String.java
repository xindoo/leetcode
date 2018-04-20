public class Solution {
    public int firstUniqChar(String s) {
        int[] vis = new int[256];
        for (int i = 0; i < s.length(); i++) {
            vis[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (1 == vis[s.charAt(i)-'a']) {
                return i;
            }
        }
        return -1;
    }
}