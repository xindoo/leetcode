public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        int len = str.length;
        int nextlen = 1;
        int pos = 0;
        while (true) {
            int cnt = 0;
            for (int i = pos; i < pos+nextlen && i < len; i++) {
                if (!str[i].equals("#"))
                    cnt++;
            }
            pos += nextlen;
            nextlen = cnt*2;
            if (0 == nextlen)
                break;
        }
        if (pos == len)
            return true;
        else
            return false;
    }
}