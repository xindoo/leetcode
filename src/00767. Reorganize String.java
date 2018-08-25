class Solution {
    public String reorganizeString(String S) {
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i)-'a']++;
        }
        char pre = '$';
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        while (cnt < S.length()) {
            int maxpos = -1;
            int maxcnt = 0;
            for (int i = 0; i < 26; i++) {
                if ((char)(i+'a') == pre || arr[i] == 0) {
                    continue;
                }
                if (arr[i] > maxcnt) {
                    maxcnt = arr[i];
                    maxpos = i;
                }
            }
            if (maxpos == -1) {
                return "";
            }
            cnt++;
            arr[maxpos]--;
            pre = (char)(maxpos+'a');
            sb.append(pre);

        }

        return sb.toString();
    }
}