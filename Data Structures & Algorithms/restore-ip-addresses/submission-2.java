class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        f(s, 0, 0, new StringBuilder());
        return res;
    }

    void f(String s, int idx, int cnt, StringBuilder sb) {
        if(cnt == 4) {
            if (idx == s.length()) {
                String ip = sb.toString();
                res.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        for(int i = idx; i < idx + 3 && i < s.length(); i++) {
            String num = s.substring(idx, i + 1);
            int value = Integer.valueOf(num);
            if(value >= 0 && value <= 255 && (num.length() == 1 || num.charAt(0) != '0')) {
                int prevLen = sb.length();
                sb.append(num).append('.');
                f(s, i + 1, cnt + 1, sb);
                sb.setLength(prevLen);
            }
        }
    }
}