class Solution {

    public int longestSubarray(int[] nums) {
        int maxE = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            maxE = Math.max(maxE,nums[i]);
        }
        int curr = 0;
        int maxL = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == maxE){
                curr++;
                maxL = Math.max(curr,maxL);
            }
            else{
                curr=0;
            }
        }
        return maxL;
    }
}