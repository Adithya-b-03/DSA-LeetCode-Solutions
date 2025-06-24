class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxf = 0;
        int maxl = 0;
        int hash[] = new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,hash[s.charAt(r)-'A']);
            if(r-l+1-maxf> k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxl = Math.max(r-l+1,maxl);
            r++;
        }
        return maxl;
    }
}