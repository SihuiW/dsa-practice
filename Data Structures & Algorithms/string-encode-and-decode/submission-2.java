class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int p = 0;

        while(p < str.length()) {
            int len = 0;
            while(Character.isDigit(str.charAt(p))) {
                len = len * 10 + (str.charAt(p) - '0');
                p++;
            }
            String s = str.substring(p + 1, p + 1 + len);
            list.add(s);
            p = p + 1 + len;
        }
        return list;
    }
}
