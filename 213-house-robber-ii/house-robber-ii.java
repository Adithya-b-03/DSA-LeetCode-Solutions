import java.util.Arrays;

class Solution {
    public int helper(int i, int[] nums, int[] dp) {
        if (i == 0) return nums[0];
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int take = nums[i] + helper(i - 2, nums, dp);
        int notTake = helper(i - 1, nums, dp);
        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Rob from index 0 to n-2
        int[] arr1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] dp1 = new int[arr1.length];
        Arrays.fill(dp1, -1);
        int max1 = helper(arr1.length - 1, arr1, dp1);

        // Case 2: Rob from index 1 to n-1
        int[] arr2 = Arrays.copyOfRange(nums, 1, n);
        int[] dp2 = new int[arr2.length];
        Arrays.fill(dp2, -1);
        int max2 = helper(arr2.length - 1, arr2, dp2);

        return Math.max(max1, max2);
    }
}
