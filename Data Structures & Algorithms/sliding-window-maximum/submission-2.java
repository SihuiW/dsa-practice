class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[r]) {
                window.pollLast();
            }
            window.offerLast(r);
            if(window.peekFirst() < l) window.pollFirst();

            if(r - l + 1 == k) {
                list.add(nums[window.peek()]);
                l++;
            }
            r++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
