public class Solution {
    public int majorityElement(int[] num) {

        int majornum = num[0];
        int cnt = 1;
        for(int i = 1; i < num.length; i++){
            if (cnt == 0) {
                cnt++;
                majornum = num[i];
            } else if(majornum == num[i]){
                cnt++;
            } else {
                cnt--;
            }

        }
        return majornum;
    }
}