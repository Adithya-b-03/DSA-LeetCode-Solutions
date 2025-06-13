class Solution {
    public int findNoPairs(int[] nums, int diff, int p){
        int c = 0;
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i+1]-nums[i] <= diff){
                c++;
                i++;
            }
        }
        return c;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, h = nums[nums.length-1]-nums[0];
        int ans = 0;
        while(l<=h){
            int mid = l+(h-l)/2;
            int c = findNoPairs(nums,mid,p);
            if(c >= p){
                h = mid-1;
                ans = mid;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
}