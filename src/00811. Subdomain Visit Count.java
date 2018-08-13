import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<String>();
        if (cpdomains == null)
            return result;
        
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String s : cpdomains) {
            String[] strs = s.split(" ");
            Integer cnt = Integer.valueOf(strs[0]);
            String[] str =strs[1].split("\\.");

            String d1 = strs[1];
            String d2;
            String d3;
            if(str.length == 2) {
                d2 = str[1];
                put(map, d2, cnt);
            }
            else {
                d2 = str[1]+"."+str[2];
                d3 = str[2];
                put(map, d2, cnt);
                put(map, d3, cnt);
            }
            put(map, d1, cnt);
        }
        for(String d : map.keySet()) {
            result.add(map.get(d)+" "+d);
        }
        return result;
    }

    public void put(Map<String, Integer> map, String d1, Integer cnt) {
        Integer c = map.getOrDefault(d1, 0);
        map.put(d1, cnt+c);
    }
}