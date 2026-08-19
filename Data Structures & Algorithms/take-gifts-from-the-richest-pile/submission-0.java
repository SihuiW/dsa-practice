class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int g: gifts) {
            pq.add(g);
        }

        while(k > 0) {
            int max = pq.poll();
            int remain = (int)Math.sqrt(max);
            pq.offer(remain);
            k--;
        }

        long res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}