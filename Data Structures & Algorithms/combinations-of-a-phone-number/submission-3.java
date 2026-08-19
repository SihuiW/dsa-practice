class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        f(map, 0, digits, new StringBuilder());
        return res;
    }

    void f(String[] map, int idx, String digits, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (char c : letters.toCharArray()) {
            sb.append(c);
            f(map, idx + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}