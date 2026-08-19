class Solution {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        String[] map = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        f(map, digits, 0, new StringBuilder());
        return res;
    }

    void f(String[] map, String digits, int idx, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            res.add(new String(sb));
            return;

        }
        int num = digits.charAt(idx) - '0';
        for(char c: map[num].toCharArray()) {
            sb.append(c);
            f(map, digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}