class Solution {
    public int largestRectangleArea(int[] heights) {
        // 这道题就看每一个柱子能往左右扩充多少
        // 维护一个大压小的单调栈
        // 只要新的高度比当前栈顶的矮，就说明右边界只能到这里了
        // 而它的左边界就是离它最近的那个栈顶元素
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]) {
                int index = stk.pop();
                int h = heights[index];
                int left = stk.isEmpty()? -1 : stk.peek();
                res = Math.max(res, (i - left - 1) * h);
            }
            stk.push(i);

        }

        while(!stk.isEmpty()) {
            int index = stk.pop();
            int h = heights[index];
            int left = stk.isEmpty()? -1: stk.peek(); 
            res = Math.max(res, (n - left - 1) * h);
        }

        return res;
    }
}
