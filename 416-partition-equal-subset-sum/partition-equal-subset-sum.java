class Solution {
    public boolean helper(int i,int t,int[] nums,int[][] dp){
        if(t==0){
            return true;
        }
        if(i==0){
            return (nums[i] == t);
        }
        if(dp[i][t] != -1){
            return dp[i][t]==1 ? true : false;
        }
        boolean nt = helper(i-1,t,nums,dp);
        boolean ta = false;
        if(nums[i] <= t){
            ta = helper(i-1,t-nums[i],nums,dp);
        }
        dp[i][t] = (ta || nt) ? 1 : 0;
        return dp[i][t] == 1;
    }
    public boolean canPartition(int[] nums) {
        int s = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            s += nums[i];
        }
        if(s%2==1){
            return false;
        }
        int t = s/2;
        int[][] dp = new int[n][t+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < t+1 ;j++){
                dp[i][j] = -1;
            }
        }
        return helper(n-1,t,nums,dp);
    }
}