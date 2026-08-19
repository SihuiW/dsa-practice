class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]) {
                int idx = stk.pop();
                int width = stk.isEmpty() ? i : i - 1 - stk.peek();
                res = Math.max(res, heights[idx] * width);
            }
            stk.push(i);
        }
        int n = heights.length;
        while(!stk.isEmpty()) {
            int idx = stk.pop();
            int width = stk.isEmpty() ? n : n - 1 - stk.peek();
            res = Math.max(res, heights[idx] * width);
        }
        return res;
    }
}