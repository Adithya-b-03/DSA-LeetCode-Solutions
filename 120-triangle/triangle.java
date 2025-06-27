class Solution {
    public int helper(int i,int j,int[][] dp,List<List<Integer>> triangle,int rows){
        if(i == rows-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        int d = triangle.get(i).get(j) + helper(i+1,j,dp,triangle,rows);
        int diag = triangle.get(i).get(j) + helper(i+1,j+1,dp,triangle,rows);
        return dp[i][j] = Math.min(d,diag);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        // List<List<Integer>> dp = new List<List<Integer>>();
        int dp[][] = new int[rows][triangle.get(rows-1).size()];
        for(int i=0 ; i<rows; i++){
            for(int j=0 ; j<triangle.get(rows-1).size() ; j++){
                dp[i][j] = -1;
            }
        }
        return helper(0,0,dp,triangle,rows);
    }
}