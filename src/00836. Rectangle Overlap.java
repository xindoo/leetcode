/**
 * 开始找重叠,想的很复杂, 但反过来想, 什么时候没有重叠, 代码就很简单了
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (!(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1]));
    }
}