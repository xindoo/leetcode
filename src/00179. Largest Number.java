import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = ""+nums[i];
        }
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        StringBuffer sb = new StringBuffer("");
        for (String str: strs) {
            if (sb.length() == 0 && str.equals("0"))
                continue;
            sb.append(str);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}