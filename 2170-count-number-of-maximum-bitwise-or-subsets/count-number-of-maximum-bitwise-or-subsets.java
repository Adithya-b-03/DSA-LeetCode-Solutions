class Solution {
    int maxOr = 0;
    public int count(int i, int c, int[] nums){
        if(i == nums.length){
            if(c == maxOr){
                return 1;
            }
            return 0;
        }
        int t = count(i+1,c|nums[i],nums);
        int nt = count(i+1,c,nums);
        return t+nt;
    }
    public int countMaxOrSubsets(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            maxOr = maxOr | nums[i];
        }
        int c = count(0,0,nums);
        return c;
    }
}