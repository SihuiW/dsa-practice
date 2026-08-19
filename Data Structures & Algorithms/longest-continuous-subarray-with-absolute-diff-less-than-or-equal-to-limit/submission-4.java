class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < nums.length) {
            int n = nums[r];
            while(!minQ.isEmpty() && minQ.peekLast() > n) {
                minQ.removeLast();
            }
            while(!maxQ.isEmpty() && maxQ.peekLast() < n) {
                maxQ.removeLast();
            }
            minQ.addLast(n);
            maxQ.addLast(n);

            r++;

            while(maxQ.peekFirst() - minQ.peekFirst() > limit) {
                int ll = nums[l];
                if(maxQ.peekFirst() == ll) {
                    maxQ.removeFirst();
                }
                if(minQ.peekFirst() == ll) {
                    minQ.removeFirst();
                }
                l++;
            }

            res = Math.max(res, r - l);
        }
        return res;
    }
}