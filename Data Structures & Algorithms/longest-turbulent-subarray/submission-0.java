class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // 从0位置开始
        // 如果0位置的数比1位置的大 那就说明是用的是第二种方法
        // 到1位置时 应该是比后一个小才能继续
        // 有一个最大长度初始化为0 扩展就记录
        int maxLen = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            int curLen = 1;
            for(int j = i + 1; j < arr.length; j++) {
                int nxt = arr[j];
                int pre = arr[j - 1];
                if(pre == nxt) {
                    break;
                }
                int curDir = nxt > pre ? 1: -1;
                if(flag == 0) {
                    curLen = 2;
                    flag = curDir;
                } else if (curDir == -flag) {
                    curLen++;
                    flag = curDir;
                } else {
                    break;
                }

            }
            maxLen = Math.max(maxLen, curLen);
        }
        
        return maxLen;
    }
}