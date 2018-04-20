class Solution {
public:
    int sqrt(int num) {
        int start=0;
        int end=0;
        int tmp=num;
        int digits=0;
        while(tmp > 0)
        {
            digits++;
            tmp=tmp/10;
        }
        for(int i=0;i<(digits+1)/2;i++)
            end=end*10+9;
        if(end > 46340) 
            end=46340; 
        if(end > num/2+1 )
            end=(num+1)/2;   
        int med=0;      
        while(start <= end)
        {
            med=(start+end+1)/2;    
            if( med >= 46340)
               return 46340;
            if(med*med <= num && (med+1)*(med+1)>num)
               return med;
            
            if(med*med < num)
                start=med; 
            else
                end=med;
        }
    }
};