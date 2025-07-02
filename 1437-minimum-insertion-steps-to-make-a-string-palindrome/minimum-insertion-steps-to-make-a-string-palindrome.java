class Solution {
     public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0 ; i<=m ; i++){
            dp[0][i] = 0;
        }
        for(int i=0 ; i<=m ; i++){
            dp[i][0] = 0;
        }
        for(int i=1 ; i<=m ;i++){
            for(int j=1 ; j<=n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}