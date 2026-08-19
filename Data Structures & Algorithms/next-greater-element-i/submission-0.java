class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] record = new int[10001];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(record, -1);
        for(int n: nums2) {
            while(!stk.isEmpty() && stk.peek() < n) {
                record[stk.pop()] = n;
            }
            stk.push(n);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = record[nums1[i]];
        }
        return res;
    }
}