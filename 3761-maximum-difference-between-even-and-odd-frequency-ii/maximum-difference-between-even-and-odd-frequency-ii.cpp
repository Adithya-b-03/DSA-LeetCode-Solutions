class Solution {
public:
    int func(int x,int y,int k, vector<vector<int>>& pref){
        int trackMin[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                trackMin[i][j] = 1e5;
            }
        }
        vector<int> xpref = pref[x], ypref = pref[y];
        int n = xpref.size();
        int i=0, j = k; // i ... j  sliding window extremas
        int ans = INT_MIN;
        while(j<n){
            if(ypref[j] != ypref[i]){
                while(j-i >= k){
                    int xp = xpref[i]%2, yp = ypref[i]%2;
                    trackMin[xp][yp] = min(trackMin[xp][yp], xpref[i] - ypref[i]);
                    i++;
                }
            }
            int max_at_j = xpref[j] - ypref[j] - trackMin[1^(xpref[j]%2)][ypref[j]%2];
            ans = max(ans, max_at_j);
            j++;
        }
        return ans;
    }
    int maxDifference(string s, int k) {
        int n = s.size();
        vector<vector<int>> pref(5,vector<int>(n+1));
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                pref[j][i+1] = pref[j][i];
            }
            pref[s[i]-'0'][i+1]++;
        }
        int ans = INT_MIN;
        for(int x=0;x<5;x++){
            if(pref[x][n]==0) continue;
            for(int y=0;y<5;y++){
                if(pref[y][n]==0 || x==y) continue;
                ans = max(ans, func(x,y,k,pref));
                // func returns max possible diff considering as if only x and y is present in the string
            }
        }
        return ans;
    }
};