class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int idx = stk.pop();
                res[idx] = i - idx;
            }
            stk.push(i);
        }
        return res;
        
    }
}
