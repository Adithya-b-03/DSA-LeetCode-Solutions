class Solution {
    public int helper(int i,int j,int dp[][],int[][] obstacleGrid){
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int top = helper(i-1,j,dp,obstacleGrid);
        int left = helper(i,j-1,dp,obstacleGrid);
        return dp[i][j] = top+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0 ; i < obstacleGrid.length ; i++){
            for(int j = 0 ; j < obstacleGrid[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return helper(obstacleGrid.length-1,obstacleGrid[0].length-1,dp,obstacleGrid);
    }
}