class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // 2 3 1 5 4
        // 5 4 3 2 1
        for(int n: nums) {
            pq.offer(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
