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
     public static int min(int[] arr){
        int m = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]<m){
                m = arr[i];
            }
        }
        return m;
    }
    public static boolean possible(int arr[],int day,int m,int k){
        int c = 0, noOfBoq = 0;
        for(int i = 0 ; i < arr.length ;i++){
            if(arr[i] <= day){
                c++;
            }
            else{
                noOfBoq += c/k;
                c = 0;
            }
           
        }
        noOfBoq += c/k;
         if(noOfBoq >= m){
                return true;
            }
            else{
                return false;
            }
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){
            return -1;
        }
        int l = min(bloomDay), h = max(bloomDay);
        int ans = -1;
        while(l <= h){
            int mid = (l+h)/2;
            if(possible(bloomDay,mid,m,k) == true){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
}