class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        int required = t.length(), formed = 0;

        int[] window = new int[128];

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (need[ch] > 0 && window[ch] <= need[ch]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (need[leftChar] > 0 && window[leftChar] <= need[leftChar]) {
                    formed--;
                }
                window[leftChar]--;
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
