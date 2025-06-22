class Solution {
    public String[] divideString(String s, int k, char fill) {
        int m = (int) Math.ceil((double)(s.length()) / k);  
        String[] ans = new String[m];
        int i = 0, j = 0;

        while (i + k <= s.length()) {
            String t = s.substring(i, i + k);
            ans[j++] = t;
            i += k;
        }

        if (i < s.length()) {
            String t = s.substring(i);
            int remaining = k - t.length();
            StringBuilder t1 = new StringBuilder(t);
            while (remaining-- > 0) {
                t1.append(fill);
            }
            ans[j] = t1.toString();
        }

        return ans;
    }
}
