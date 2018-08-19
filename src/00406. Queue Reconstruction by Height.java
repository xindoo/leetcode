import java.util.Arrays;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        int[][] ans = new int[people.length][people[0].length];
        Arrays.sort(people, (int[] a, int[] b) -> (b[0] == a[0] ? a[1] -b[1]: b[0] - a[0]));
        int cnt = 0;
        for (int i = 0; i < people.length; i++) {
            int cntBigger = 0;
            for (int j = 0; j <= cnt; j++) {
                if (cntBigger == people[i][1]) {
                    for (int k = ++cnt; k > j; k--) {
                        if (k >= people.length) {
                            continue;
                        }
                        ans[k] = ans[k-1];
                    }
                    ans[j] = people[i];
                    break;
                }
                if (ans[j][0] >= people[i][0]) {
                    cntBigger++;
                }
            }
        }
        return ans;
    }
}