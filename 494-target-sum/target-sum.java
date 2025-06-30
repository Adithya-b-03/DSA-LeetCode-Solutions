class Solution {
    public int helper(int i,int t,int[] nums,int[][] dp){
        if(i==0){
            if(t==0 && nums[i]==0){
                return 2;
            }
            if(t==0 || nums[i]==t){
                return 1;
            }
            return 0;
        }
        if(dp[i][t] != -1){
            return dp[i][t];
        }
        int nt = helper(i-1,t,nums,dp);
        int ta = 0;
        if(nums[i] <= t){
            ta = helper(i-1,t-nums[i],nums,dp);
        }
        return nt+ta;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int tot = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            tot += nums[i];
        }
        if(tot-target < 0 || (tot-target)%2 == 1){
            return 0;
        }
        int t = (tot-target)/2;
        int [][]dp = new int[n][t+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=t; j++){
                dp[i][j] = -1;
            }
        }
        return helper(n-1,t,nums,dp);
    }
}