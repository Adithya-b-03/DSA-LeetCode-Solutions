class Solution {
    public int helper(int[] nums,int k){
        int l = 0;
        int r = 0;
        int c = 0;
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        while(r<nums.length){
            mp.put(nums[r],mp.getOrDefault(nums[r], 0) + 1);
            while(mp.size() > k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            c = c + (r-l+1);
            r++;
        }
        return c;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (helper(nums,k)-helper(nums,k-1));
    }
}