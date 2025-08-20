class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int n = num.length();

        // Build monotonic increasing stack
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && k > 0 && s.peek() > num.charAt(i)) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        // Remove remaining if needed
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        // Build result (in reverse)
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If empty return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
