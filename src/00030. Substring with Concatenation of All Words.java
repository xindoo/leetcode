import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    boolean getAns;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        if (s ==null || words == null || words.length == 0 || s.length() == 0)
            return list;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (len != str.length()) {
                return list;
            }
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        for (int i = 0; i <= s.length() - len*words.length; i++) {
            getAns = true;
            dfs(s, i, i+len*words.length, map, len);
            if (getAns) {
                list.add(i);
            }
        }
        return list;
    }
    private void dfs(String s, int start, int end, Map<String, Integer> map, int len) {
        if (start == end || getAns == false) {
            return;
        }
        String subStr = s.substring(start, start+len);

        int cnt = map.getOrDefault(subStr, 0);
        if (cnt == 0) {
            getAns = false;
            return;
        }
        map.put(subStr, cnt-1);
        dfs(s, start+len, end, map, len);
        map.put(subStr, cnt);
    }
}