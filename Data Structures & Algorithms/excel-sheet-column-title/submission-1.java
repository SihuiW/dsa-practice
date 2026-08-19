class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put(i + 1, (char)('A' + i));
        }
        while (columnNumber > 0) {
            columnNumber--;
            int idx = columnNumber % 26;
            sb.append(map.get(idx + 1));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}