class Solution {
    public boolean judgeCircle(String moves) {
        int count = 0;
        for(int i = 0; i<moves.length(); i++) {
            char ch = moves.charAt(i);
            switch(ch) {
                case 'U': count += 2;
                            break;
                case 'D': count -= 2;
                            break;
                case 'L': count += 1;
                            break;
                case 'R': count -= 1;
                            break;
                default: return false;
            }
        }
        return (count == 0);
    }
}