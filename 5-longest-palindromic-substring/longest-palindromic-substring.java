class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }
        boolean dp[][] = new boolean [n][n];
        int start = 0;
        int maxLen = 1;
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        for(int j=0; j<n-1; j++){
            if(s.charAt(j) == s.charAt(j+1)){
                dp[j][j+1] = true;
                start = j;
                maxLen = 2;
            }
        }
        for(int len=3; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}