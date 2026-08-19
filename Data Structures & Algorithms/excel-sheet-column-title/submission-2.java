class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            sb.append((char)('A' + offset));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}