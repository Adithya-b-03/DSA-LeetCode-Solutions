class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int n = fruits.size(), ans = 0;
        int bas = 0, cnt = 0, l = 0;
        vector<int> freq(1e5 + 1);
        for(int r=0;r<n;r++){
            if(freq[fruits[r]]==0) bas++;
            freq[fruits[r]]++;
            cnt++;
            while(bas>2){
                if(freq[fruits[l]]==1) bas--;
                freq[fruits[l]]--;
                l++; cnt--;
            }
            // reaches this point , bas <=2, therefore we have a valid count
            ans = max(ans,cnt);
        }
        return ans;
    }
};