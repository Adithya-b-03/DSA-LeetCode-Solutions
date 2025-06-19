class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;

            // If this part is already sorted
            if (nums[l] <= nums[h]) {
                ans = Math.min(ans, nums[l]);
                break;
            }

            // Left part is sorted
            if (nums[l] <= nums[m]) {
                ans = Math.min(ans, nums[l]);
                l = m + 1;
            }
            // Right part is sorted
            else {
                ans = Math.min(ans, nums[m]);
                h = m - 1;
            }
        }

        return ans;
    }
}
