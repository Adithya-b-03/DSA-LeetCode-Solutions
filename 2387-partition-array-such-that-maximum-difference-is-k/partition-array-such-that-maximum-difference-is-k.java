class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int st = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i]-st > k){
                ans++;
                st = nums[i];
            }
        }
        return ans;
    }
}