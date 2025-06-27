class Solution {
    public int helper(int i,int j,int[][] dp,int[][] grid){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0){
            return (int)1e9;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int top = grid[i][j] + helper(i-1,j,dp,grid);
        int left = grid[i][j] + helper(i,j-1,dp,grid);
        return dp[i][j] = Math.min(top,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        return helper(m-1,n-1,dp,grid);   
    }
}