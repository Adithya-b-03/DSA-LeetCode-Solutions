class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                ans++;
            }
        }
        long val = 0;
        int i = 0;
        while(i < Math.min(n,32)){
            if(s.charAt(n-i-1) == '1'){
                int p = (int)Math.pow(2,i);
                if(val+p > k){
                    break;
                }
                ans++;
                val += p;
            }
            i++;
        }
        return ans;
    }
}