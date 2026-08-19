class Solution {
    // 3 3 2 1 5
    public int lastStoneWeight(int[] stones) {
        if(stones.length <= 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int s: stones) {
            pq.add(s);
        }
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(pq.isEmpty()) return a;
            int b = pq.poll();
            if(a != b) {
                pq.offer(Math.abs(a - b));
            }
        }
        return 0; 
    }
}
