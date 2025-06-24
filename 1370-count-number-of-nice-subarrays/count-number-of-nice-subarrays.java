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
            s += (nums[r]%2);
            while(s > goal){
                s = s - (nums[l]%2);
                l++;
            }
            if( s <= goal ){
                c = c + (r-l+1);
            }
            r++;
        }
        return c;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int a = helper(nums,k);
        int b = helper(nums,k-1);
        return a-b;
    }
}
