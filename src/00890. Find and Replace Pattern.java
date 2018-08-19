import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> mapw = new HashMap<>();
            Map<Character, Character> mapp = new HashMap<>();
            boolean isAns = true;
            for (int i = 0; i < pattern.length(); i++) {
                char cw = word.charAt(i);
                char cp = pattern.charAt(i);
                if (mapp.get(cw) != null && !mapp.get(cw).equals(cp)) {
                    isAns =false;
                    continue;
                }
                if (mapw.get(cp) != null && !mapw.get(cp).equals(cw)) {
                    isAns =false;
                    continue;
                }
                mapp.put(cw, cp);
                mapw.put(cp, cw);
                
            }
            if (isAns) {

                ans.add(word);
            }
        }
        return ans;
    }
}