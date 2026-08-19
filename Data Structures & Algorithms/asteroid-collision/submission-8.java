class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int a: asteroids) {
            while(!stk.isEmpty() && stk.peek() > 0 && a < 0) {
                int pre = stk.pop();
                int diff = pre + a;
                if(diff > 0) {
                    stk.push(pre);
                    a = 0;
                } else if(diff == 0){
                    a = 0;
                }
            } 
            if(a != 0) stk.push(a);
        }
        int[] res = new int[stk.size()];
        int idx = 0;
        for(int a: stk) {
            res[idx++] = a;
        }
        return res;
    }
}