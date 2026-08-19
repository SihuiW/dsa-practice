class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        f(s, new StringBuilder(), 0, 0);
        return res;
    }

    void f(String s, StringBuilder sb, int start, int part) {
        if(part > 4) return;
        if(part == 4) {
            if(start == s.length()) {
                String temp = sb.toString();
                res.add(temp.substring(0, temp.length() - 1));
            }
            return;
        }

        if(start == s.length() && part < 4) return;

        for(int i = start; i < s.length(); i++) {
            if(check(s, start, i)) {
                int len = sb.length();
                sb.append(s.substring(start, i + 1)).append('.');
                f(s, sb, i + 1, part + 1);
                sb.setLength(len);
            }
        }
    }

    boolean check(String s, int i, int j) {
        String str = s.substring(i, j + 1);
        if(str.length() > 3) return false;
        if(str.length() > 1 && str.charAt(0) == '0') return false;
        if(Integer.parseInt(str) > 255) return false;
        return true;
    }
}