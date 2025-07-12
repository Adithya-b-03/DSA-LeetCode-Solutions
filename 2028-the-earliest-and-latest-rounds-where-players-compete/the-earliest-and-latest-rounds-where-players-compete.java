class Solution {
    int N=0;
    int f=0;
    int s=0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public void helper(int mask,int r,int i,int j){
        if(i>=j){
            helper(mask,r+1,0,N);
        }
        else if((mask&(1<<i)) == 0){
            helper(mask,r,i+1,j);
        }
        else if((mask&(1<<j)) == 0){
            helper(mask,r,i,j-1);
        }
        else if(i==f && j==s){
            max = Math.max(max,r);
            min = Math.min(min,r);
        }
        else{
            if(i!=f && i!=s){
                helper((mask)^(1<<i),r,i+1,j-1);
            }
            if(j!=f && j!=s){
                helper((mask)^(1<<j),r,i+1,j-1);
            }
        }
    }
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        N = n-1;
        f = firstPlayer-1;
        s = secondPlayer-1;
        helper((1<<n)-1,1,0,n-1);
        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}