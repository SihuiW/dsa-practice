class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips.length == 1) return trips[0][0] <= capacity ? true: false;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] trip: trips) {
            pq.offer(trip);
        }
        while(!pq.isEmpty()) {
            int[] t1 = pq.poll();
            if(pq.isEmpty()) return t1[0] <= capacity ? true: false;
            int[] t2 = pq.poll();
            if(t1[0] > capacity || t2[0] > capacity) return false;
            if(t1[0] + t2[0] <= capacity && t2[1] < t1[2]) {
                pq.offer(new int[]{t1[0] + t2[0], t1[1], t2[2]});
            } else if (t2[1] < t1[2]) {
                return false;
            } else {
                pq.offer(t2);
            }
        }
        return true;
    }
    
}