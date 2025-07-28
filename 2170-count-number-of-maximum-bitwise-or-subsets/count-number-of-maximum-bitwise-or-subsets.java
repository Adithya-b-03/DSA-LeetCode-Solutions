class Solution {
    int maxOr = 0;
    public int count(int i, int c, int[] nums,int dp[][]){
        if(i == nums.length){
            if(c == maxOr){
                return 1;
            }
            return 0;
        }
        if(dp[i][c] != -1){
            return dp[i][c];
        }
        int t = count(i+1,c|nums[i],nums,dp);
        int nt = count(i+1,c,nums,dp);
        return dp[i][c] = t+nt;
    }
    public int countMaxOrSubsets(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            maxOr = maxOr | nums[i];
        }
        int[][] dp = new int[nums.length+1][maxOr+1];
        for(int i = 0 ; i < nums.length+1 ; i++){
            for(int j = 0 ; j < maxOr+1 ; j++){
                dp[i][j] = -1;
            }
        }
        int c = count(0,0,nums,dp);
        return c;
    }
}