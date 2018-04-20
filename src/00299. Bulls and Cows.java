public class Solution {
    public String getHint(String secret, String guess) {
    int n = secret.length();
    int bulls = 0;
    int cows = 0;
    if (n != 0) {
        int[] counts = new int[10];
        char[] sVal = secret.toCharArray();
        for (char ch : sVal) {
            counts[ch - '0']++;
        }
        char[] gVal = guess.toCharArray();
        for (char ch : gVal) {
            int idx = ch - '0';
            if (counts[idx] > 0) {
                counts[idx]--;
                cows++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (sVal[i] == gVal[i]) {
                cows--;
                bulls++;
            }
        }
    }
    return bulls + "A" + cows + "B";
}
}