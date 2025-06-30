class Solution {
    public int helper(int i,int[] a,int t,int[][] dp){
        if(i==0){
            if(t%a[i]==0){
                return t/a[i];
            }
            return (int)1e9;
        }
        if(dp[i][t] != -1){
            return dp[i][t];
        }
        int nt = 0 + helper(i-1,a,t,dp);
        int ta = (int)1e9;
        if(a[i] <= t){
            ta = 1 + helper(i,a,t-a[i],dp);
        }
        return dp[i][t] = Math.min(ta,nt);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }
        int ans = helper(n-1,coins,amount,dp);
        if(ans >= (int)1e9){
            return -1;
        }
        return ans;
    }
}