class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(l < r){
            int area = Math.min(height[l],height[r])*(r-l);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}