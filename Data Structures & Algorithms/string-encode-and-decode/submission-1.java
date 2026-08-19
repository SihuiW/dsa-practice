class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int p = 0;
        while(p < str.length()) {
            int size = 0;
            while(str.charAt(p) != '#') {
                size = size * 10 + (str.charAt(p++) - '0');
            }
            p++;
            res.add(str.substring(p, p + size));
            p = p + size;
        }
        return res;
    }
}
