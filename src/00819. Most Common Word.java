import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[ !?',;.]+");
        Set<String> set = new HashSet<String>();
        Arrays.stream(banned).forEach(str-> set.add(str));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = null;
        List<String> list = Arrays.stream(words).map(String::toLowerCase).filter(str -> str.length() > 0 && !set.contains(str))
                .collect(Collectors.toList());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            int cnt = map.getOrDefault(str, 0) + 1;
            if (cnt > max) {
                max = cnt;
                ans = str;
            }
            map.put(str, cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.mostCommonWord("Wsfd sd sd sadaa, dfsdf, dfsf,dfsd. dfsdfds,dfsd, Bob!, dfs?", new String[]{"dfsdf", "dfsf", "dfsd"});
    }
}