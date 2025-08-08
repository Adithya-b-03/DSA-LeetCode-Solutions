class Solution {
    public double soupServings(int n) {
        // Scale down to units of 25 ml
        int m = (int) Math.ceil(n / 25.0);

        // dp[i][j] = probability that A empties first with i units of A and j units of B
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

        // Helper function to compute probability from four serving options
        // Using lambda inside a class requires final variables, so we use a method reference
        class Helper {
            double getDP(int i, int j) {
                double ans = 0.0;
                ans += dp.get(Math.max(i - 4, 0)).get(j);
                ans += dp.get(Math.max(i - 3, 0)).get(Math.max(j - 1, 0));
                ans += dp.get(Math.max(i - 2, 0)).get(Math.max(j - 2, 0));
                ans += dp.get(Math.max(i - 1, 0)).get(Math.max(j - 3, 0));
                return ans / 4.0;
            }
        }
        Helper helper = new Helper();

        // Base case: both A and B empty → probability = 0.5
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);

        // Fill DP table
        for (int k = 1; k <= m; k++) {
            // If A is empty, probability = 1
            dp.get(0).put(k, 1.0);
            // If B is empty, probability = 0
            dp.put(k, new HashMap<>());
            dp.get(k).put(0, 0.0);

            // Fill for all i,j where max(i,j) = k
            for (int j = 1; j <= k; j++) {
                dp.get(j).put(k, helper.getDP(j, k));
                dp.get(k).put(j, helper.getDP(k, j));
            }

            // Optimization: if probability is almost 1, return early
            if (1 - dp.get(k).get(k) < 1e-5) {
                return 1.0;
            }
        }

        // Return probability for (m, m)
        return dp.get(m).get(m);
    }
}

