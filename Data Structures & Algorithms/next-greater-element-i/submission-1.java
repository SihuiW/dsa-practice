class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) map.put(nums1[i], i);
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for(int n: nums2) {
            while(!stk.isEmpty() && stk.peek() < n) {
                int num = stk.pop();
                if(map.containsKey(num)) {
                    int idx = map.get(num);
                    res[idx] = n;
                }
            }
            stk.push(n);
        }
        return res;
    }
}