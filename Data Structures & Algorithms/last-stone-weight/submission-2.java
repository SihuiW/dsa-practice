class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int stone: stones) {
            pq.offer(stone);
        }
        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            if(first != second) {
                pq.offer(Math.abs(first - second));
            }
        }



        return pq.isEmpty()? 0: pq.peek();
    }
}
