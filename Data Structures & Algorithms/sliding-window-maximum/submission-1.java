class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> window = new PriorityQueue<>((a, b) -> b - a);
        int l = 0, r = 0;
        while(r < nums.length) {
            int a = nums[r++];
            window.offer(a);
            if(window.size() > k) {
                int b = nums[l++];
                window.remove(b);
            }
            if(window.size() == k) list.add(window.peek());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
