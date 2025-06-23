class Solution {
    public int findMaxRow(int [][]mat,int c){
        int m = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0 ; i < mat.length ; i++){
            if(mat[i][c] > m){
                m = mat[i][c];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int h = mat[0].length-1;
        int ans[] = {-1,-1};
        while(l<=h){
            int m = (l+h)/2;
            int maxRow = findMaxRow(mat,m);
            int left = m-1 >= 0 ? mat[maxRow][m-1] : -1;
            int right = m+1 < mat[0].length ? mat[maxRow][m+1] : -1;
            if(mat[maxRow][m] > left && mat[maxRow][m] > right){
                ans[0] = maxRow;
                ans[1] = m;
                return ans;
            }
            else if(left > mat[maxRow][m]){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
}