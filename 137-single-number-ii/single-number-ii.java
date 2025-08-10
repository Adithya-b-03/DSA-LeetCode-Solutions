class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bitIndex = 0 ; bitIndex < 32 ; bitIndex++){
            int c = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if((nums[i] & (1<<bitIndex)) != 0){
                    c++;
                }
            }
            if(c%3 != 0){
                ans = ans | (1<<bitIndex);
            }
        }
        return ans;
    }
}