class Solution {
     public int longestCommonSubsequence(String text1, String text2) {

        int c[][] = new int[text1.length()+1][text2.length()+1];

        for(int j = 0; j < text2.length()+1; j++)
        {
            c[0][j] = 0;
        }
        for(int i = 0; i < text1.length()+1; i++)
        {
            c[i][0] = 0;
        }
        for(int i = 1; i < text1.length()+1; i++)
        {
            for(int j = 1; j < text2.length()+1; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    c[i][j] = 1 + c[i-1][j-1]; 
                }
                else
                {
                    if(c[i-1][j] >= c[i][j-1])
                    {
                        c[i][j] = c[i-1][j];
                    }
                    else
                    {
                        c[i][j] = c[i][j-1];
                    }
                }
            }
        }
        return (c[text1.length()][text2.length()]);
    }
    public int minDistance(String word1, String word2) {
        int l = longestCommonSubsequence(word1,word2);
        int ins = word2.length()-l;
        int del = word1.length()-l;
        return ins+del;
        
    }
}