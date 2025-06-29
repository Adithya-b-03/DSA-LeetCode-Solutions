class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < n; i++) left.add(nums[i]);
        for (int i = n; i < 2 * n; i++) right.add(nums[i]);

        Map<Integer, List<Integer>> leftMap = getSubsetSums(left);
        Map<Integer, List<Integer>> rightMap = getSubsetSums(right);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            List<Integer> leftSums = leftMap.get(i);
            List<Integer> rightSums = rightMap.get(n - i);
            Collections.sort(rightSums);

            for (int lSum : leftSums) {
                int target = totalSum / 2 - lSum;
                int idx = Collections.binarySearch(rightSums, target);
                if (idx < 0) idx = -idx - 1;

                // Check both lower and upper bound
                if (idx < rightSums.size()) {
                    int rSum = rightSums.get(idx);
                    int curr = lSum + rSum;
                    res = Math.min(res, Math.abs(totalSum - 2 * curr));
                }

                if (idx > 0) {
                    int rSum = rightSums.get(idx - 1);
                    int curr = lSum + rSum;
                    res = Math.min(res, Math.abs(totalSum - 2 * curr));
                }
            }
        }

        return res;
    }

    private Map<Integer, List<Integer>> getSubsetSums(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums.get(i);
                    bits++;
                }
            }
            map.computeIfAbsent(bits, k -> new ArrayList<>()).add(sum);
        }

        return map;
    }
}
