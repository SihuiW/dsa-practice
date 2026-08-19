class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 当前位
                int p1 = i + j;
                // 进位位
                int p2 = i + j + 1;
                
                // 加上之前已经有的值
                int sum = mul + res[p2];
                
                res[p2] = sum % 10;           // 当前位
                res[p1] += sum / 10;          // 进位加到高位
            }
        }
        
        // 转成字符串，跳过前导 0
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : res) {
            if (leadingZero && digit == 0) continue;
            leadingZero = false;
            sb.append(digit);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}