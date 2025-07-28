class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 1 ; i <= n-2 ; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            int l = i-1;
            while(l>=0 && nums[l]==nums[i]){
                l--;
            }
            int r = i+1;
            while(r<=n-1 && nums[r]==nums[i]){
                r++;
            }
            if(l>=0 && r<=n-1){
                if(nums[i]<nums[l] && nums[i]<nums[r]){
                    c++;
                }
                else if(nums[i]>nums[l] && nums[i]>nums[r]){
                    c++;
                }
            }
        }
        return c;
    }
}