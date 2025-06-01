class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        int l = 0, h = nums.length-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(target == nums[mid]){
                ans[0] = mid;
                h = mid-1;
            }
            else if(target <= nums[mid]){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        l = 0;
        h = nums.length-1;
         while(l <= h){
            int mid = (l+h)/2;
            if(target == nums[mid]){
                ans[1] = mid;
                l = mid+1;
            }
            else if(target <= nums[mid]){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
}