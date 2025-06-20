class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int m = (l+h)/2;
            int miss = arr[m] - (m+1);
            if(miss<k){
                l = m+1;
            }
            else{
                h = m-1;
            }

        }
        return l + k;
    }
}