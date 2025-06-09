#define ll long long
class Solution {
    public: int findNoSteps(int n,ll p1,ll p2){
        int steps = 0;
        while(p1 <= n){
            steps += (min((ll)n+1,p2)-p1);
            p1 *= 10;
            p2 *= 10;
        }
        return steps;
    }
     int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while(k>0){
            int cnt = findNoSteps(n,curr,curr+1);
            if(cnt <= k){
                curr++;
                k -= cnt;
            }
            else{
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
};