class Solution {
public:
    int singleNumber(int A[], int n) {
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < n; i++)
        {
            threes = twos & A[i]; 
            twos = twos | ones & A[i]; 
            ones = ones | A[i];
            
            twos = twos & ~threes; 
            ones = ones & ~threes;
        }
        return ones; 
    }
};