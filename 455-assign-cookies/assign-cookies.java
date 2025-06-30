class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int m = s.length;
        int n = g.length;
        int l = 0, r = 0;
        while(l < m && r < n){
            if(s[l] >= g[r]){
                r++;
            }
            l++;
        }
        return r;
    }
}