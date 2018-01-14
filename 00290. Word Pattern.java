import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> mapr = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            }
            else {
                map.put(pattern.charAt(i), strs[i]);
            }
            if (mapr.containsKey(strs[i])) {
                if (!mapr.get(strs[i]).equals(pattern.charAt(i)))
                    return false;
            }
            else {
                mapr.put(strs[i], pattern.charAt(i));
            }
        }
        return true;
    }
}