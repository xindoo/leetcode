import java.util.Arrays;

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        if (null == A || A.length == 0) {
            return  0;
        }
        String[] arr = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = change(A[i]);
        }
        Arrays.sort(arr);
        String pre = "-0";
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!pre.equals(arr[i])) {
                cnt++;
            }
            pre = arr[i];
        }
        return cnt++;
    }
    private String change(String s){
        char[] c0 = new char[s.length()/2 + s.length()%2];
        for (int i = 0; i < s.length() && i*2 < s.length(); i++) {
            c0[i] = s.charAt(i*2);
        }
        Arrays.sort(c0);
        char[] c1 = new char[s.length()/2 + s.length()%2];
        for (int i = 0; i < s.length() && i*2+1 < s.length(); i++) {
            c1[i] = s.charAt(i*2+1);
        }
        Arrays.sort(c1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c0.length; i++) {
            sb.append(c0[i]);
        }
        for (int i = 0; i < c1.length; i++) {
            sb.append(c1[i]);
        }
        return sb.toString();
    }
}