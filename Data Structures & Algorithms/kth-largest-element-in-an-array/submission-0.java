class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // 2 3 1 5 4
        // 5 4 3 2 1
        for(int n: nums) {
            pq.offer(n);
        }
        while(k > 1) {
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
