class Solution {
    public static int max(int[] arr){
        int m = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>m){
                m = arr[i];
            }
        }
        return m;
    }
    public static int helper(int[] nums,int d){
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += Math.ceil((double)(nums[i])/(double)(d));
        }
        return s;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = max(nums);
        int ans = -1;
        while(l<=h){
            int m = (l+h)/2;
            if(helper(nums,m) <= threshold){
                ans = m;
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
}