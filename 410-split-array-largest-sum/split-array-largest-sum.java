class Solution {
    public int helper(int nums[],int k,int m){
        int n = 1;
        long c = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(c + nums[i] <= m){
                c += nums[i];
            }
            else{
                n++;
                c = nums[i];
            }
        }
        return n;
    }
    public int max(int a[]){
        int m = Integer.MIN_VALUE;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i]>m){
                m = a[i];
            }
        }
        return m;
    }
    public int sum(int a[]){
        int s = 0;
        for(int i = 0 ; i < a.length ; i++){
            s += a[i];
        }
        return s;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length == 1){
            return nums[0];
        }
        int l = max(nums);
        int h = sum(nums);
        while(l <= h){
            int m = (l+h)/2;
            int cnt = helper(nums,k,m);
            if(cnt > k){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return l;
    }
}