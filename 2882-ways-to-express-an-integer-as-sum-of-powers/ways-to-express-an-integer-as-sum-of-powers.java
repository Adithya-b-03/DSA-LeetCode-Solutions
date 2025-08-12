
class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: one way to make sum 0

        for (int i = 1; i <= n; i++) {
            int v = (int) Math.pow(i, x); // Raise i to the power x
            if (v > n) break; // No need to continue if v exceeds n

            // Traverse backwards to avoid reusing the same number multiple times
            for (int j = n; j >= v; j--) {
                dp[j] = (dp[j] + dp[j - v]) % mod;
            }
        }

        return dp[n]; // Number of ways to form sum exactly n
    }
}