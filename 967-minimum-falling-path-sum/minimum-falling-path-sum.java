class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int up = matrix[i][j] + dp[i-1][j];
                int ld = (j>0) ? matrix[i][j] + dp[i-1][j-1] : (int)1e9;
                int rd = (j<n-1) ? matrix[i][j] + dp[i-1][j+1] : (int)1e9;
                dp[i][j] = Math.min(up,Math.min(ld,rd));
            }
        }
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans,dp[m-1][i]);
        }
        return ans;
    }
}