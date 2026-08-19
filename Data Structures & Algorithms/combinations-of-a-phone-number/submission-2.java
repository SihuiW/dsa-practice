class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        f(map, 0, digits, new StringBuilder());
        return res;
    }

    void f(Map<Character, String> map, int idx, String digits, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for (char c : letters.toCharArray()) {
            sb.append(c);
            f(map, idx + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}