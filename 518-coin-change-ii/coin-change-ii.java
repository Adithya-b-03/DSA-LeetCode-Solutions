class Solution {
    public int helper(int i,int t,int[] a,int[][] dp){
        if(i == 0){
            if(t%a[i] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][t] != -1){
            return dp[i][t];
        }
        int nt = helper(i-1,t,a,dp);
        int ta = 0;
        if(a[i] <= t){
            ta = helper(i,t-a[i],a,dp);
        }
        return dp[i][t] = nt+ta;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }
        return helper(n-1,amount,coins,dp);
    }
}