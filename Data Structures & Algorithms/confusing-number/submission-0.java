class Solution {
    public boolean confusingNumber(int n) {
        if(n == 0) return false;
        String s = String.valueOf(n);
        String invaild = "23457";
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(invaild.contains(String.valueOf(c))) return false;
            if(c == '6') sb.append(9);
            if(c == '9') sb.append(6);
            if(c == '1') sb.append(1);
            if(c == '0') sb.append(0);
            if(c == '8') sb.append(8);
        }
        int nn = Integer.valueOf(sb.reverse().toString());
        return n != nn;
    }
}
