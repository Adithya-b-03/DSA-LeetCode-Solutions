class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] c = new int[m + 1][n + 1];

        // Step 1: Compute LCS dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    c[i][j] = 1 + c[i - 1][j - 1];
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }

        // Step 2: Build Shortest Common Supersequence using LCS table
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (c[i - 1][j] > c[i][j - 1]) {
                sb.append(text1.charAt(i - 1));
                i--;
            } else {
                sb.append(text2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) {
            sb.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(text2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
}
