class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m] == target){
                return true;
            }
            if(nums[l] == nums[m] && nums[m] == nums[h]){
                l++;
                h--;
                continue;
            }
            if(nums[l] <= nums[m]){
                if(target >= nums[l] && target < nums[m]){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(target > nums[m] && target <= nums[h]){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
        }
        return false;
    }
}