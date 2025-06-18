import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array

        int n = nums.length;
        if (n % 3 != 0) return new int[0][0]; // Cannot divide into triplets

        int[][] result = new int[n / 3][3];
        int idx = 0;

        for (int i = 0; i < n; i += 3) {
            int min = nums[i];
            int mid = nums[i + 1];
            int max = nums[i + 2];

            // Step 3: Check max - min <= k
            if (max - min > k) {
                return new int[0][0]; // Invalid group, return empty
            }

            result[idx][0] = min;
            result[idx][1] = mid;
            result[idx][2] = max;
            idx++;
        }

        return result;
    }
}
