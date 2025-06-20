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
    public static int possible(int[] arr,int capacity){
        int d = 1,l =0;
        for(int i = 0; i < arr.length; i++){
            if(l+arr[i] > capacity){
                l = arr[i];
                d++;
            }
            else{
                l += arr[i];
            }
        }
        return d;
    }
    public static int sum(int[] arr){
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            ans += arr[i];
        }
        return ans;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = max(weights);
        int h = sum(weights);
        int ans = 0;
        while(l<=h){
            int m = (l+h)/2;
            int t = possible(weights,m);
            if(t <= days){
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