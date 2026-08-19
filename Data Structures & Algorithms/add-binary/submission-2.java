class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1, p2 = b.length() - 1;
        int carry = 0;
        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int n1 = p1 >= 0 ? a.charAt(p1--) - '0': 0;
            int n2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            int total = carry + n1 + n2;
            carry = total / 2;
            sb.append(total % 2);
        }
        return sb.reverse().toString();
    }
}