class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1s.length && j < v2s.length) {
            int a = Integer.parseInt(v1s[i]);
            int b = Integer.parseInt(v2s[j]);
            if (a > b)
                return 1;
            if (a < b)
                return -1;
            i++;
            j++;
        }
        while (i < v1s.length) {
            if (Integer.parseInt(v1s[i++]) != 0)
                return 1;
        }
        while (j < v2s.length) {
            if (Integer.parseInt(v2s[j++]) != 0)
                return -1;
        }
        return 0;
    }
    public static void main(String[]  args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("0.1", "1.0"));
    }
}