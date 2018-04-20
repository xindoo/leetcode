class Solution {
    public int[] constructRectangle(int area) {
        int l = (int)Math.sqrt(area*1.0);
        while (l <= area) {
            if (area%l == 0 && l >= area/l) {
                break;
            }
            l+=1;
        }
        return new int[]{l, area/l};
    }
}