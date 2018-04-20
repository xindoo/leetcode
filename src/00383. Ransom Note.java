class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[128];
        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i)- 'A']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) -'A']--;
        }
        for (int i = 0; i < 128; i++) {
            if (cnt[i] > 0)
                return false;
        }
        return true;
    }
}