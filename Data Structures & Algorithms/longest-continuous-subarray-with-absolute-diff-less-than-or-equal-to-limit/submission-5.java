class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            while (!maxDeque.isEmpty() && nums[r] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(r);
            while (!minDeque.isEmpty() && nums[r] < nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                l++;
                if (maxDeque.peekFirst() < l)
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() < l)
                    minDeque.pollFirst();
            }
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }
}