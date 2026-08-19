class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stk = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int idx = stk.pop();
                res[idx] = i - idx;
            }
            stk.push(i);
        }
        return res;
    }
}
