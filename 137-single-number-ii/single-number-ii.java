class Solution {
    public int helper(int[] nums){
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i+=3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
    public int singleNumber(int[] nums) {
        // int ans = 0;
        // for(int bitIndex = 0 ; bitIndex < 32 ; bitIndex++){
        //     int c = 0;
        //     for(int i = 0 ; i < nums.length ; i++){
        //         if((nums[i] & (1<<bitIndex)) != 0){
        //             c++;
        //         }
        //     }
        //     if(c%3 != 0){
        //         ans = ans | (1<<bitIndex);
        //     }
        // }
        // return ans;
        return helper(nums);
    }
}