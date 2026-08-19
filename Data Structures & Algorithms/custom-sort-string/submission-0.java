class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                pq.add(new int[]{(int)c, map.get(c)});
            } else {
                pq.add(new int[]{(int)c, 0});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            char c = (char)pq.poll()[0];
            sb.append(c);
        }
        return sb.toString();
    }
}