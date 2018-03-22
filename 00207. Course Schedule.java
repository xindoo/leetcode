import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isFinished = new boolean[numCourses];
        int[] preCourseCount = new int[numCourses];
        boolean[][] hasRelation = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            preCourseCount[prerequisites[i][1]]++;
            hasRelation[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                if (isFinished[i])
                    continue;
                if (preCourseCount[i] <= 0) {
                    isFinished[i] = true;
                    for (int j = 0; j < numCourses; j++) {
                        if (hasRelation[i][j]) {
                            preCourseCount[j]--;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (false == isFinished[i]) {
                return false;
            }
        }
        return true;
    }
}