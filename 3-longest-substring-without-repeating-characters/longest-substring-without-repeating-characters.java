class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l = 0;
       int r = 0;
       int maxLen = 0;
       HashMap<Character,Integer> mpp = new HashMap<Character,Integer>();
       while(r<s.length()){
        if(mpp.containsKey(s.charAt(r))){
            if(mpp.get(s.charAt(r)) >= l){
                l = mpp.get(s.charAt(r))+1;
            }
            
        }
        int len = r-l+1;
            maxLen = Math.max(len,maxLen);
            mpp.put(s.charAt(r),r);
            r++; 
       } 
       return maxLen;
    }
}