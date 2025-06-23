class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int h = matrix.length*matrix[0].length-1;
        while(l<=h){
            int m = (l+h)/2;
            int r = m/matrix[0].length;
            int c = m%matrix[0].length;
            if(matrix[r][c] ==  target){
                return true;
            }
            else if(target > matrix[r][c]){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return false;
    }
}