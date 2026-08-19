class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;
        //从0一路开始走 如果方向不对或者遇到相等的了 就从这个不对的这里重写向后走，记录长度
        int start = 0;
        int pre = start;
        int nxt = pre + 1;
        int maxLen = 0;
        int dir = 0;
        while(nxt < arr.length) {
            int a = arr[pre];
            int b = arr[nxt];
            if(a == b) {
                maxLen = Math.max(pre - start + 1, maxLen);
                start = nxt;
                pre = start;
                nxt = pre + 1;
                dir = 0;
                continue;
            }
            int curDir = b > a? 1: -1;
            if(dir == 0 || curDir == -dir) {
                pre++;
                nxt++;
                dir = curDir;
                maxLen = Math.max(maxLen, pre - start + 1);
            } else {
                maxLen = Math.max(pre - start + 1, maxLen);
                start = pre;
                pre = start;
                nxt = pre + 1;
                dir = 0;
            }
        }
        //maxLen = Math.max(maxLen, pre - start + 1);
        return maxLen;
    }
}