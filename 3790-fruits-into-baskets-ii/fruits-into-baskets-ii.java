class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans=0;
        for(int i = 0 ; i < n ; i++){
            int f = 1;
            for(int j = 0 ; j < n ; j++){
                if(baskets[j] >= fruits[i]){
                    baskets[j] = 0;
                    f = 0;
                    break;              
                }
            }
            if(f==1){
                ans++;
            }
        }        
        return ans;
    }
}