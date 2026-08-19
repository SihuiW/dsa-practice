class Solution {
    public String multiply(String num1, String num2) {
        long n1 = 0;
        long n2 = 0;
        for(char c: num1.toCharArray()) {
            n1 = n1 * 10 + (c - '0');
        }
        for(char c: num2.toCharArray()) {
            n2 = n2 * 10 + (c - '0');
        }
        return String.valueOf(n1 * n2);
    }
}
