package lettercombphone;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char c: mapping[index].toCharArray()) {
                    result.add(t + c);
                }
            }
        }
        return result;
    }
}
