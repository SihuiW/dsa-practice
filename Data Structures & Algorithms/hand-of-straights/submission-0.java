class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h: hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        while(!map.isEmpty()) {
            int first = map.firstKey();
            int freq = map.get(first);
            for(int i = 0; i < groupSize; i++) {
                int card = first + i;
                if(!map.containsKey(card)) return false;

                int cnt = map.get(card);
                if(cnt < freq) return false;
                if(cnt == freq) {
                    map.remove(card);
                } else {
                    map.put(card, cnt - freq);
                }
            }
        }

        return true;
        
    }
}
