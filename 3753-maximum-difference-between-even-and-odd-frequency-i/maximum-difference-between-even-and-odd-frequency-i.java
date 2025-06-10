class Solution {
    public int maxDifference(String s) {
        int a[] =new int[26];
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            a[ch-'a']++;
        }
        int odd = Integer.MIN_VALUE, even = Integer.MAX_VALUE;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i]==0){
                continue;
            }
            if(a[i]%2 == 0){
                even = Math.min(even,a[i]);
            }
            if(a[i]%2 != 0){
                odd = Math.max(odd,a[i]);
            }
        }
        return (odd-even);
    }
}