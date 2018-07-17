import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        list.add(S);
        int idx = 0;
        while(idx < S.length()) {
            char ch = S.charAt(idx);
            if(Character.isLetter(ch)) {
                List<String> nextList = new ArrayList<>();
                for(String str : list) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.setCharAt(idx, Character.toUpperCase(ch));
                    nextList.add(sb.toString());
                    sb.setCharAt(idx, Character.toLowerCase(ch));
                    nextList.add(sb.toString());
                }
                list = nextList;
            }
            idx++;
        }
        return list;
    }
}