class FreqStack {
    // 元素 -> 频率
    private Map<Integer, Integer> freq = new HashMap<>();
    // 频率 -> 该频率下元素的栈（后进的在栈顶）
    private Map<Integer, Deque<Integer>> group = new HashMap<>();
    // 当前最大频率
    private int maxFreq = 0;

    public FreqStack() {}

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);

        // 把 val 压入对应频率的栈
        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        // 从最大频率的栈顶弹出
        Deque<Integer> stack = group.get(maxFreq);
        int val = stack.pop();

        // 更新频率
        freq.put(val, freq.get(val) - 1);

        // 如果当前最大频率的栈空了，maxFreq--
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}