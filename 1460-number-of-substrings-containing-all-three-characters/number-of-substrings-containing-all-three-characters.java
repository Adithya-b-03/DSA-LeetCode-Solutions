class Solution {
    public int min(int[] hash){
        int m = Integer.MAX_VALUE;
        for(int i = 0 ; i < hash.length ; i++){
            if(hash[i]<m){
                m = hash[i];
            }
        }
        return m;
    }
    public int numberOfSubstrings(String s) {
        int c = 0;
        int hash[] = {-1,-1,-1};
        for(int i = 0 ; i < s.length() ; i++){
            hash[s.charAt(i)-'a'] = i;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                c += min(hash)+1;
            }
        }
        return c;
    }
}