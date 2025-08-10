class Solution {
public:
    int minBitFlips(int start, int goal) {
        int a= start ^ goal;
        int c = 0;
        while(a!=0){
            if((a&1)==1){
                c++;
            }
            a = a>>1;
        }
        return c;
    }
};