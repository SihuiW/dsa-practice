class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new ArrayDeque<>();
        for(int a: asteroids) {
            boolean alive = true;
            while(alive && !stk.isEmpty() && stk.peek() > 0 && a < 0) {
                if(-a > stk.peek()) {
                    stk.pop();
                } else if(-a == stk.peek()) {
                    stk.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if(alive) stk.push(a);
        }
        int[] res = new int[stk.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        return res;
    }
}