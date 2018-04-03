import java.util.HashMap;

class Solution {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxLen = 0;
        for (String str: strs) {
            int index = 0;
            while (str.charAt(index) =='\t') {
                index++;
            }
            hm.put(index, str.length()-index);
            if (str.contains(".")) {
                int sumLen = 0;
                for (int i = 0; i <= index; i++) {
                    sumLen += (hm.get(i)+1);
                }
                maxLen = Math.max(maxLen, sumLen-1);
            }
        }
        return maxLen;
    }
}