class Solution {
    public int helper(int[] nums,int goal){
        int l = 0;
        int r = 0;
        int c = 0;
        int s = 0;
        if(goal < 0){
            return 0;
        }
        while(r < nums.length){
            s += nums[r];
            while(s > goal){
                s = s - nums[l];
                l++;
            }
            if( s <= goal ){
                c = c + (r-l+1);
            }
            r++;
        }
        return c;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = helper(nums,goal);
        int b = helper(nums,goal-1);
        return a-b;
    }
}