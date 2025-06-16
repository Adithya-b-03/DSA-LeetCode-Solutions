class Solution {
    public static void solve(int c,char[][] board,List<List<String>> ans,int[]left,int[]lowerdiag,int[]upperdiag,int n){
        if(c == n){
            ans.add(construct(board,n));
            return;
        }
        for(int r=0; r<n; r++){
            if(left[r] == 0 && lowerdiag[r+c] == 0 && upperdiag[n-1+c-r] == 0){
                left[r] = 1;
                lowerdiag[r+c] = 1;
                upperdiag[n-1+c-r] = 1;
                board[r][c] = 'Q';
                solve(c+1,board,ans,left,lowerdiag,upperdiag,n);
                left[r] = 0;
                lowerdiag[r+c] = 0;
                upperdiag[n-1+c-r] = 0;
                board[r][c] = '.';
            }
        }
    }
    public static List<String> construct(char[][]board,int n){
        List<String> r = new LinkedList<String>();
        for(int i = 0 ; i < n ; i++){
            r.add(new String(board[i]));
        }
        return r;
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for( int i=0; i<n; i++ ){
            for( int j=0; j<n; j++ ){
                board[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        int lowerdiag[] = new int[2*n-1];
        int rightdiag[] = new int[2*n-1];
        int left[] = new int[n];
        solve(0,board,ans,left,lowerdiag,rightdiag,n);
        return ans;
    }
}