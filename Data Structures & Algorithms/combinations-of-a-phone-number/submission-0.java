class Solution {
    // 把数字和字母作为kv放入map里
    // f方法：传入index 从index对应字母群选一个 sb加入 进入下一个递归 
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
        f(digits, 0, new StringBuilder(), map);
        return res;
        
    }

    void f(String digits, int index, StringBuilder sb, Map<Character, String> map) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        
        for(Character c: letters.toCharArray()) {
            sb.append(c);
            f(digits, index + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
