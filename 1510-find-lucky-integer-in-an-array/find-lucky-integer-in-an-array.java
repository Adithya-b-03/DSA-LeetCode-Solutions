class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for(int i = 0 ; i < arr.length ; i++){
            freq[arr[i]]++;
        }
        for(int i = 500 ; i >= 1 ; i--){
            if(i == freq[i]){
                return i;
            }
        }
        return -1;
    }
}