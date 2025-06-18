class Solution {
    public boolean helper(int i,int j,char[][] board,String word,int k){
        if(k == word.length()){
            return true;
        }
        if(i<0 || j<0 || j==board[0].length || i==board.length || board[i][j] != word.charAt(k)){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean left = helper(i,j-1,board,word,k+1);
        boolean right = helper(i,j+1,board,word,k+1);
        boolean up = helper(i-1,j,board,word,k+1);
        boolean down = helper(i+1,j,board,word,k+1);
        board[i][j] = c;
        return left||right||up||down;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(i,j,board,word,0))
                        return true;
                }
            }
        }
        return false;
    }
}