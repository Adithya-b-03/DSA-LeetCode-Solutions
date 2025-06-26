class Solution {
    public int helper(int i,int[] nums,int[] dp){
        if(i == 0){
            return nums[i];
        }
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int t = nums[i] + helper(i-2,nums,dp);
        int nt = 0 + helper(i-1,nums,dp);
        return dp[i] = Math.max(t,nt);
    }
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
}