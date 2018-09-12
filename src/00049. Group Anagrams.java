import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 简单题,把每个字符串按其字符排序好之后的结果归类就好了
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String newstr = helper(str);
            List<String> list = map.get(newstr);
            if (list == null) {
                list = new LinkedList<>();
                map.put(newstr, list);
            }
            list.add(str);
        }
        List<List<String>> ans = new LinkedList<>();
        for (List<String> list:map.values()) {
            ans.add(list);
        }
        return ans;
    }
    private String helper(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}