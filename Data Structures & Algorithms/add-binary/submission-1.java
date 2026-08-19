class Solution {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int p1 = aa.length - 1;
        int p2 = bb.length - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int num1 = (p1 >= 0) ? aa[p1--] - '0': 0;
            int num2 = (p2 >= 0) ? bb[p2--] - '0': 0;
            int num = num1 + num2 + carry;
            carry = num / 2;
            sb.append(num % 2);
        }
        
        return sb.reverse().toString();
    }
}