class Solution {
    public long distributeCandies(int n, int limit) {
        return( c(n+2)-3 * c(n-limit+1)+3 * c(n-(limit+1)*2+2) - c(n-3*(limit+1)+2) );

    }
    public long c(int x){
        if(x<0){
            return 0;
        }
        return((long)x*(x-1))/2;
    }
}