class Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int maxdiff = Integer.MIN_VALUE;
        for(int i = 0 ; i < len ; i++){
            for(int j = i ; j < len ; j++){
                if(nums[i] < nums[j]){
                    maxdiff = Math.max(maxdiff,nums[j]-nums[i]);
                }
            }
        }
        if(maxdiff != Integer.MIN_VALUE){
            return maxdiff;
        }
        else{
            return -1;
        }
    }
}