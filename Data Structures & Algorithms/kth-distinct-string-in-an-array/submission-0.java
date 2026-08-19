class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String c: arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(String c: arr) {
            if(map.get(c) == 1) {
                if(k == 1) return c;
                k--;
            }
        }
        return "";
    }
}