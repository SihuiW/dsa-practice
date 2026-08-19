class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        int index = 0;
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int preIndex = stk.pop();
                res[preIndex] = i - preIndex;
            }
            stk.push(i);
        }
        return res;
    }
}
