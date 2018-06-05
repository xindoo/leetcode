class Solution {
    public boolean detectCapitalUse(String word) {
        boolean hasLower = false;
        int capCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= 'z' && word.charAt(i) >= 'a') {
                hasLower = true;
            } else {
                if (hasLower) {
                    return false;
                }
                capCount++;
            }
        }
        if (capCount > 1 && hasLower)
            return false;
        return true;
    }
}