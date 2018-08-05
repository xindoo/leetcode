import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int s = 0;
        int e = people.length-1;
        while (s < e) {
            while (s < e && people[s] + people[e] > limit) {
                e--;
            }
            if (s != e) {
                s++;
                e--;
                cnt++;
            }
        }
        cnt += people.length - cnt*2;
        return cnt;
    }
}