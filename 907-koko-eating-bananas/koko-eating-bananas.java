class Solution {
    public static int max(int[] piles){
        int m = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(piles[i]>m){
                m = piles[i];
            }
        }
        return m;
    }
    public int helper(int[] a,int h){
        int ans = 0;
        for(int i = 0 ; i < a.length ; i++){
            ans += Math.ceil((double)(a[i])/(double)(h));
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0,high = max(piles);
        int ans = -1;
        while(low<=high){
            int m = (low+high)/2;
            if(helper(piles,m)<=h){
                ans = m;
                high = m-1;
            }
            else{
                low = m+1;
            }
        }
        return ans;
    }
}