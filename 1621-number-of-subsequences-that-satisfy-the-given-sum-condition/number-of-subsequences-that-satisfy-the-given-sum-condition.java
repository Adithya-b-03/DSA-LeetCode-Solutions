class Solution {
    final int MOD = (int)1e9+7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int pow[] = new int[n];
        pow[0] = 1;
        for(int i = 1 ; i < n ; i++){
            pow[i] = (pow[i-1]*2)%MOD;
        }
        int l = 0 , r = n-1;
        int ans = 0;
        while(l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            }
            else{
                ans = (ans+pow[r-l])%MOD;
                l++;
            }
        }
        return ans;
    }
}