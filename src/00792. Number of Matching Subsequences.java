import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Pair {
        int wordi;
        int index;
        Pair(int x, int y) {
            wordi = x;
            index = y;
        }
    }
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Pair>> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            List<Pair> list = map.get(words[i].charAt(0));
            if (list == null) {
                list = new ArrayList<>();
                map.put(words[i].charAt(0), list);
            }
            list.add(new Pair(i, 0));
        }
        for (int i = 0; i < S.length(); i++) {
            List<Pair> list = map.get(S.charAt(i));
            if (list == null)
                continue;
            map.put(S.charAt(i), new ArrayList<>());
            for (Pair pair: list) {
                if (++pair.index == words[pair.wordi].length()){
                    cnt++;
                } else {
                    List<Pair> list2 = map.get(words[pair.wordi].charAt(pair.index));
                    if (list2 == null) {
                        list2 = new ArrayList<Pair>();
                        map.put(words[pair.wordi].charAt(pair.index), list2);
                    }
                    list2.add(pair);
                }
            }
        }
        return cnt;
    }
}