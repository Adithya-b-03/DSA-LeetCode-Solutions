import java.util.*;

class Solution {
    public void helper(int index, String digits, Map<Character, String> map, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (int j = 0; j < letters.length(); j++) {
            current.append(letters.charAt(j));
            helper(index + 1, digits, map, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(0, digits, map, new StringBuilder(), result);
        return result;
    }
}
