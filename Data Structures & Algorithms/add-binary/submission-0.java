class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int sum = carry;
            if(p1 >= 0) sum += a.charAt(p1--) - '0';
            if(p2 >= 0) sum += b.charAt(p2--) - '0';
            sb.append((char)(sum % 2 + '0'));
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}