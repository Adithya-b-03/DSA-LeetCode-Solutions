class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int odd = nums[0]%2==1 ? 1 : 0;
        int even = nums[0]%2==0 ? 1 : 0;
        int alt = 1;
        boolean isExpectingEven = nums[0]%2==1 ? true : false;
        for(int i = 1 ; i < n ; i++){
            if((isExpectingEven==true && nums[i]%2==0)||(isExpectingEven==false && nums[i]%2==1)){
                alt++;
                isExpectingEven = !isExpectingEven;
            }
            if(nums[i]%2 == 1){
                odd++;
            }
            else{
                even++;
            }
        }
        return Math.max(alt,Math.max(even,odd));
    }
}