class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ps[] = new int[n];
        int ss[] = new int[n];
        ps[0] = height[0];
        ss[n-1] = height[n-1];
        for(int i = 1 ; i < n ; i++){
            ps[i] = Math.max(ps[i-1],height[i]);
        }
        for(int i = n-2; i >= 0 ; i--){
            ss[i] = Math.max(ss[i+1],height[i]);
        }
        int tot = 0;
        for(int i = 0 ; i < n ; i++){
            int ml = ps[i];
            int mr = ss[i];
            if(height[i] < ml && height[i] < mr){
                tot += Math.min(ml,mr) - height[i];
            }
        }
        return tot;
    }
}