class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        List<Integer> sizes = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for(String str: strs) {
            sizes.add(str.length());
        }
        for(int size: sizes) {
            res.append(size).append(",");
        }
        res.append("#");
        for(String str: strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int index = 0;
        while(str.charAt(index) != '#') {
            StringBuilder cur = new StringBuilder();
            while(str.charAt(index) != ',') {
                cur.append(str.charAt(index));
                index++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            index++;
        }
        index++;
        for(int sz: sizes) {
            res.add(str.substring(index,index+sz));
            index += sz;
        }
        return res;
        
    }
}
